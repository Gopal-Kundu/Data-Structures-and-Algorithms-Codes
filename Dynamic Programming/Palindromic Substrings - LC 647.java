// https://leetcode.com/problems/palindromic-substrings/description/

class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += expand(s, i, i);
            count += expand(s, i, i+1);
        }
        return count;
    }
    int expand(String s, int left, int right){
        int count = 0;
        while (left != -1 && right != s.length()) {
                if (s.charAt(left) != s.charAt(right))
                    break;
                else {
                    count++;
                }
                left--; right++;
            }
            return count;
    }
}

class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += expand(s, i, i);
            count += expand(s, i, i+1);
        }
        return count;
    }
    int expand(String s, int left, int right){
        int count = 0;
        while (left != -1 && right != s.length()) {
                if (s.charAt(left) != s.charAt(right))
                    break;
                else {
                    count++;
                }
                left--; right++;
            }
            return count;
    }
}