//https://leetcode.com/problems/counting-bits/description/
class Solution {
    public int[] countBits(int n) {
        int ans[] = new int[n + 1];
        if(n == 0) return ans;
        ans[1] = 1;
        for (int i = 2; i < ans.length; i++) {
            ans[i] = ans[i/2] + ans[i%2];   
        }
        return ans;
    }
}