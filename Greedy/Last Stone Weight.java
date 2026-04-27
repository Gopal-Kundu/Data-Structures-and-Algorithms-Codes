//https://leetcode.com/problems/last-stone-weight/

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones) maxHeap.offer(stone);
        while(maxHeap.size() > 1){
            int num1 = maxHeap.poll();
            int num2 = maxHeap.poll();
            if(num1 == num2) continue;
            else maxHeap.offer(Math.abs(num1 - num2));
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}