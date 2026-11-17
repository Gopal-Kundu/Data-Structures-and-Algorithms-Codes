//https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/

class Solution {
    public int appendCharacters(String s, String t) {
        int j = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(j < t.length() && t.charAt(j) == ch){
                j++;
            }
        }
        return t.length() - j;
    }
}