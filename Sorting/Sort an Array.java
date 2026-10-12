//https://leetcode.com/problems/sort-an-array/description/

class Solution {
    public int[] sortArray(int[] nums) {
        mergesort(nums, 0, nums.length-1);
        return nums;
    }

    void mergesort(int[] nums, int left, int right){
        if(left >= right) return;
        int mid = left + (right - left)/2;
        mergesort(nums, left, mid);
        mergesort(nums, mid+1, right);
        merge(nums, left, mid, right);
    }

    void merge(int[] nums, int left, int mid, int right){
        int i = left, j = mid+1;
        int[] temp = new int[right - left + 1];
        int idx = 0;
        while(i <= mid && j <= right){
            if(nums[i] < nums[j])
                temp[idx++] = nums[i++];
            else temp[idx++] = nums[j++];
        }

        while(i <= mid)
            temp[idx++] = nums[i++];
        while(j <= right)
            temp[idx++] = nums[j++];
        
        idx = 0;
        for(i = left; i <= right; i++)
            nums[i] = temp[idx++];
    }
}