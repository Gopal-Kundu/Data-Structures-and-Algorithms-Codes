//https://leetcode.com/problems/break-a-palindrome/description/

class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length() == 1) return "";
        char[] palin = palindrome.toCharArray();
        int n = palindrome.length();
        for(int i = 0; i < n/2; i++){
            if(palin[i] != 'a'){
                palin[i] = 'a';
                return new String(palin);
            }
        }
        palin[n-1] = 'b';
        return new String(palin);
    }
}