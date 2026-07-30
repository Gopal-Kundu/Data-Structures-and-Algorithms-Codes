//https://leetcode.com/problems/earliest-second-to-mark-indices-i/

class Solution {
    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        int n = nums.length;
        int m = changeIndices.length;

        int left = 1, right = m;
        int ans = -1;

        while(left <= right){
            int mid = (left + right)/2;

            if(can(nums, changeIndices, mid, n)){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return ans;
    }

    boolean can(int[] nums, int[] changeIndices, int T, int n){
        int last[] = new int[n];
        Arrays.fill(last, -1);

        for(int i = 0; i < T; i++){
            last[changeIndices[i] - 1] = i;
        }

        for(int i = 0; i < n; i++){
            if(last[i] == -1) return false;
        }

        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(new int[]{last[i], i});
        }

        Collections.sort(list, (a,b)-> a[0] - b[0]);

        long timeUsed = 0;
        for(int[] pair : list){
            int deadline = pair[0];
            int idx = pair[1];

            timeUsed += nums[idx] + 1;

            if(timeUsed > deadline+1)
                return false;
        }
        return true;
    }
}