//https://leetcode.com/problems/reverse-bits/description/

class Solution {
    public int reverseBits(int n) {
        int ans = 0;
        int count = 31;
        while(count != 0){
            n = n >> 1;
            if(n % 2 == 0){
                ans = (ans << 1);
            }else{
                ans = (ans << 1)+1;
            }
            count--;
        }
        return ans;
    }
}