//https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/description/

class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[0] != 1) arr[i] = 1;
            else if(i > 0 && Math.abs(arr[i] - arr[i-1]) > 1) arr[i] = arr[i-1]+1;

            max = Math.max(arr[i], max);
        }
        return max;
    }
}