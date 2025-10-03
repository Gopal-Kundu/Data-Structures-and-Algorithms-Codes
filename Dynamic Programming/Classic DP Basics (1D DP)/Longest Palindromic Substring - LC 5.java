// https://leetcode.com/problems/longest-palindromic-substring/description/

class Solution {
    public String longestPalindrome(String s) {
        String ans = ""+s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            String ans1 = expand(s, i, i);
            String ans2 = expand(s, i, i+1);
            if(ans.length() < ans1.length()) ans = ans1;
            if(ans.length() < ans2.length()) ans = ans2;
        }
        return ans;
    }
    String expand(String s, int left, int right){
        String ans = "";
        while (left != -1 && right != s.length()) {
                if (s.charAt(left) != s.charAt(right))
                    break;
                else {
                    String str = s.substring(left, right + 1);
                    if (ans.length() < str.length())
                        ans = str;
                }
                left--; right++;
            }
            return ans;
    }
}