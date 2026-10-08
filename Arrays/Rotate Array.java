//https://leetcode.com/problems/rotate-array/

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        int temp[] = new int[n];
        int idx = 0; 
        for(int i = n - k; i < n; i++){
            temp[idx++] = nums[i];
        }
        System.out.println(Arrays.toString(temp));
        for(int i = 0; i <= n - k - 1; i++){
            temp[idx++] = nums[i];
        }
        System.out.println(Arrays.toString(temp));
        for(int i = 0; i < nums.length; i++)
            nums[i] = temp[i];
        
    }
}