//https://leetcode.com/problems/check-if-all-the-integers-in-a-range-are-covered/

class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        HashSet<Integer> map = new HashSet<>();
        int i = 0;
        while(i < ranges.length){
            for(int j = ranges[i][0]; j <= ranges[i][1]; j++){
                map.add(j);
            }
            i++;
        }
        
        for(int j = left; j <= right; j++){
            if(!map.contains(j)) return false;
        }
        return true;
    }
}