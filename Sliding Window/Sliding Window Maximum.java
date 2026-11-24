//https://leetcode.com/problems/sliding-window-maximum/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deq = new ArrayDeque<>();
        for(int i = 0; i < k; i++){
            while(!deq.isEmpty() && nums[deq.peekLast()] < nums[i])
                deq.pollLast();
            if(deq.isEmpty() || nums[deq.peekLast()] >= nums[i]) deq.offerLast(i);
        }
        int[] ans = new int[n - k + 1];
        int idx = 0;
        // System.out.println(deq.peekFirst());
        if(!deq.isEmpty()) ans[idx++] = nums[deq.peekFirst()];
        int i = 1, j = k;
        while(j < n){
            while(!deq.isEmpty() && deq.peekFirst() < i) deq.pollFirst();
            while(!deq.isEmpty() && nums[deq.peekLast()] < nums[j])
                    deq.pollLast();
            if(deq.isEmpty() || nums[deq.peekLast()] >= nums[j]) deq.offerLast(j);
            ans[idx++] = nums[deq.peekFirst()];
            i++; j++;
        }
        return ans;
    }
}