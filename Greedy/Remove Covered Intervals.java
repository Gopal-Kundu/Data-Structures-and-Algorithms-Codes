//https://leetcode.com/problems/remove-covered-intervals/description/
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]) {
                return Integer.compare(b[1], a[1]); 
            }
            return Integer.compare(a[0], b[0]);
        });
        List<int[]> remainingIntervals = new ArrayList<>();
        for(int interval[] : intervals){
            int lastPos = remainingIntervals.size()-1;
            if(remainingIntervals.isEmpty())
                remainingIntervals.add(interval);
                
            else if(remainingIntervals.get(lastPos)[0] < interval[0] 
            && remainingIntervals.get(lastPos)[1] < interval[1]) 
                remainingIntervals.add(interval);
        }
        return remainingIntervals.size();
    }
}
