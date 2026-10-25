//https://leetcode.com/problems/4sum/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        if(n < 4) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j < n; j++){
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int k = j+1, m = n-1;
                while(k < m){
                    long sum = (long)nums[i] + nums[j] + nums[k] + nums[m]; 
                    if(sum < target) k++;
                    else if(sum > target) m--;
                    else {
                        res.add(Arrays.asList(
                            nums[i], nums[j], nums[k], nums[m]
                            ));
                            k++; m--;
                        while(k < m && nums[k] == nums[k-1]) k++;
                        while(k < m && nums[m] == nums[m+1]) m--;
                    }
                }
            }
        }
        return res;   
    }
}