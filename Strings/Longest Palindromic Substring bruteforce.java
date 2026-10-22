//https://leetcode.com/problems/longest-palindromic-substring/

class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                String str = s.substring(i, j+1);
                if(isPalin(str)){
                    if(str.length() > ans.length()){
                        ans = str;
                    }
                }
            }
        }
        return ans;
    }
    boolean isPalin(String s){
        int i = 0, j = s.length()-1;
        while(i <= j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++; j--;
        }
        return true;
    }
}