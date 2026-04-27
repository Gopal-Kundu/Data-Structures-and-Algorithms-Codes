//https://leetcode.com/problems/furthest-building-you-can-reach/description/

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int maxBuildingCanJump = 0;
        for(int i = 1; i < heights.length; i++){
            if(heights[i-1] >= heights[i]){
                maxBuildingCanJump = Math.max(maxBuildingCanJump, i);
                continue;
            }
            else if(heights[i-1] < heights[i]){
                int requiredBricks = heights[i] - heights[i-1];
                if( requiredBricks <= bricks){
                    bricks -= requiredBricks;
                    pq.offer(requiredBricks);
                }else if( requiredBricks > bricks){
                    int maxBrickUsedSoFar = pq.isEmpty() ? 0 : pq.peek();
                    if( ladders > 0 && maxBrickUsedSoFar >= requiredBricks){
                        pq.poll();
                        ladders--;
                        bricks += (maxBrickUsedSoFar - requiredBricks);
                        pq.offer(requiredBricks);
                    }else{
                        if(ladders > 0) ladders--;
                        else break;
                    }
                }
            }
            maxBuildingCanJump = Math.max(maxBuildingCanJump, i);
        }
        return maxBuildingCanJump;
    }
}