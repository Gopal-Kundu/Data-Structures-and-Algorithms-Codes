//https://leetcode.com/problems/add-binary/
class Solution {
    public String addBinary(String a, String b) {
        int len1 = a.length() - 1, len2 = b.length() - 1;
        String ans = "";
        int carry = 0;
        int dig1 = 0, dig2 = 0;
        while (len1 >= 0 || len2 >= 0) {
            if (len1 >= 0) {
                dig1 = a.charAt(len1--) - '0';
            } else
                dig1 = 0;
            if (len2 >= 0) {
                dig2 = b.charAt(len2--) - '0';
            } else
                dig2 = 0;
            int value = (dig1 + dig2 + carry) % 2;
            carry = (dig1 + dig2 + carry) / 2;
            ans = Integer.toString(value) + ans;
        }
        if (carry == 1)
            ans = "1" + ans;
        return ans;
    }
}