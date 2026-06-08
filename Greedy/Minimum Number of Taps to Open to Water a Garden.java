//https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/

class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] maxReach = new int[n+1];
        for(int i = 0; i < ranges.length; i++){
            int left = Math.max(0, i - ranges[i]);
            int right = Math.min(n, i + ranges[i]);
            maxReach[left] = Math.max(maxReach[left], right);
        }
        System.out.println(Arrays.toString(maxReach));
        int openedTaps = 1;
        int maxCanGo = maxReach[0];
        int currEnd = maxCanGo;
        for(int currPosition = 1; currPosition < maxReach.length; currPosition++){
            
            if(currPosition > maxCanGo) return -1;
            maxCanGo = Math.max(maxReach[currPosition], maxCanGo);
            if(currPosition == currEnd){
                if(currPosition != n) openedTaps++;
                currEnd = maxCanGo;
            }
            
        }
        return openedTaps;
    }
}