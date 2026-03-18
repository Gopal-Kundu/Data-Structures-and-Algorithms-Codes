//https://leetcode.com/problems/permutations/

class Solution {
    ArrayList<List<Integer>> answer;

    public List<List<Integer>> permute(int[] nums) {
        answer = new ArrayList<>();
        boolean[] visitedIdx = new boolean[nums.length];
        solve(nums, 0, new ArrayList<>(), visitedIdx);
        return answer;
    }

    private void solve(int[] nums, int idx, List<Integer> current, boolean[] visitedIdx) {
        if (idx >= nums.length) {
            answer.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visitedIdx[i]) {
                current.add(nums[i]);
                visitedIdx[i] = true;
                solve(nums, idx + 1, current, visitedIdx);
                current.remove(current.size() - 1);
                visitedIdx[i] = false;
            }
        }
        return;
    }
}