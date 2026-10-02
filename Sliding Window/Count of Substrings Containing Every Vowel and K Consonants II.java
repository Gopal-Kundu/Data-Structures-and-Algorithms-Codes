//https://leetcode.com/problems/count-of-substrings-containing-every-vowel-and-k-consonants-ii/

class Solution {
    public long countOfSubstrings(String word, int k) {
        return countAtMostKSubstrings(word, k) - countAtMostKSubstrings(word, k+1);
    }
    public long countAtMostKSubstrings(String word, int k){
        if(k < 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        long cnt = 0; int i = 0;
        int c = 0;
        for(int j = 0; j < word.length(); j++){
            char ch = word.charAt(j);
            if(("aeiou").contains(ch+""))
                map.put(ch, map.getOrDefault(ch, 0)+1);
            else c++;

            while(c >= k && map.size() == 5){
                cnt += word.length() - j;
                ch = word.charAt(i);
                i++;
                if(map.containsKey(ch)){
                    if(map.get(ch) == 1) map.remove(ch);
                    else map.put(ch, map.get(ch)-1);
                }else c--;
            }
    
        }
        return cnt;
    }
}
