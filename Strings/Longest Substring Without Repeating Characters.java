//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0, maxLen = 0;
        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            if(!set.contains(ch))
                set.add(ch);
            else{
                while(set.contains(ch)){
                    char lCh = s.charAt(left);
                    set.remove(lCh);
                    left++;
                }
                set.add(ch);
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}