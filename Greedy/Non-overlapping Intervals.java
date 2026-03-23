//https://leetcode.com/problems/non-overlapping-intervals/

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[1]-b[1]);
        List<int[]> nonOverLappingList = new ArrayList<>();
        for(int interval[] : intervals){
            int lastPosition = nonOverLappingList.size()-1;
            if(nonOverLappingList.isEmpty()){
                nonOverLappingList.add(interval);
            }else if(nonOverLappingList.get(lastPosition)[1] <= interval[0]){
                nonOverLappingList.add(interval);
            }
        }
        return intervals.length - nonOverLappingList.size();
    }
}