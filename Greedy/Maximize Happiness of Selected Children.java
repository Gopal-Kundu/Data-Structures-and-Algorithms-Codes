//https://leetcode.com/problems/maximize-happiness-of-selected-children/description/

class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long sum = 0;
        long decrement = 0;
        Arrays.sort(happiness);
        int i = happiness.length-1;
        while(k != 0 && i >=0){
            sum += Math.max(happiness[i] - decrement, 0);
            decrement++;
            k--;
            i--;
        }
        return sum;
    }
}