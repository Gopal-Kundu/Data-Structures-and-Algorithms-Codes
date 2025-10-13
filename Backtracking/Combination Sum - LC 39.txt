//https://leetcode.com/problems/combination-sum/description/

class Solution {
    void findCom(int[] nums, int target, int idx, List<Integer> list, List<List<Integer>> ans) {
        if (idx == nums.length || target <= 0) {
            if (target == 0)
                ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[idx]);
        findCom(nums, target - nums[idx], idx, list, ans);
        list.remove(list.size() - 1);
        findCom(nums, target, idx+1, list, ans);
        return;
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        findCom(nums, target, 0, new ArrayList<>(), ans);
        return ans;
    }
}