// https://leetcode.com/problems/longest-repeating-character-replacement/

class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0; HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0, maxLen = 0;
        for(int j = 0; j < s.length(); j++){
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            maxFreq = Math.max(maxFreq, map.get(ch));
            int lenOfSubstring = j - i + 1;
            while(lenOfSubstring - maxFreq > k){
                //Time to shink
                char chAti = s.charAt(i);
                map.put(chAti, map.get(chAti) - 1);
                i++;
                lenOfSubstring = j - i + 1;
                maxFreq = refreshMaxFrequency(map);
            }
            maxLen = Math.max(j - i + 1, maxLen);
        }
        return maxLen;
    }
    int refreshMaxFrequency(HashMap<Character, Integer> map){
        int maxFreq = 0;
        for(int val : map.values())
            maxFreq = Math.max(maxFreq, val);
        return maxFreq;
    }
}