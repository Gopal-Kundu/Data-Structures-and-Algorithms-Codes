// https://leetcode.com/problems/product-of-array-except-self/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int n = nums.length;
        for(int i = 0; i < n; i++){
            //Prefix filling
            answer[i] = (i > 0) ? answer[i-1]*nums[i-1] : 1;
        }

        int temp = 1;
        for(int i = n-1; i >=0; i--){
            //Suffix filling using temp
            temp = (i < n-1) ? temp*nums[i+1]: 1;
            answer[i] = answer[i]*temp;
        }
        return answer;
    }
}