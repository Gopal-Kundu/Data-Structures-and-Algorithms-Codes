//https://leetcode.com/contest/weekly-contest-512/problems/largest-integer-with-given-digit-sum/

class Solution {
    int digitSum(int d){
        int sum = 0;
        while(d != 0){
            sum += d%10;
            d = d/10;
        }
        return sum;
    }
    public int largestInteger(int n, int s) {
        int N = (int)Math.pow(10, n);
        if(n == 1) N = 10;
        int max = -1;
        for(int i = 0; i < N; i++){
            if(digitSum(i) == s){
                max = Math.max(max, i);
            }
        }
        return max;
    }
}