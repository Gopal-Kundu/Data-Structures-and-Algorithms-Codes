//https://leetcode.com/problems/kth-largest-element-in-an-array/description/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            if(pq.size() == k){
                if(pq.peek() < num){
                    pq.poll();
                    pq.offer(num);
                }
            }else pq.offer(num);
        }
        return pq.peek();
    }
}