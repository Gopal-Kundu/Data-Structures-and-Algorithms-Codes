//https://leetcode.com/problems/sum-of-two-integers/

class Solution {
    public int getSum(int a, int b) {
        int sum = 0;
        int carry = 0;
        carry = a & b;
        carry = carry << 1;
        sum = a ^ b ^ carry;
        return sum;
    }
}