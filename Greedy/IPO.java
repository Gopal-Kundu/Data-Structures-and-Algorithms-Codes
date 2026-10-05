//https://leetcode.com/problems/ipo/description/

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> profitsWithCapital = new PriorityQueue<>((a,b)->Integer.compare(a[0], b[0])
        );

        for(int i = 0; i < profits.length; i++){
            profitsWithCapital.offer(new int[]{capital[i], profits[i]});
        }

        PriorityQueue<int[]> initialQueue = new PriorityQueue<>((a,b)->Integer.compare(b[1], a[1]));
        
        while(k!=0){
            while(!profitsWithCapital.isEmpty() && profitsWithCapital.peek()[0] <= w){
                initialQueue.offer(profitsWithCapital.poll());
            }
            if(initialQueue.isEmpty()) break;
                w += initialQueue.poll()[1];
                k--;
        }
        return w;
    }
}
