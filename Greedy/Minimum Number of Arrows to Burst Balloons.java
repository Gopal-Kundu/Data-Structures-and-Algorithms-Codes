//https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        List<int[]> nonOverlappedInterval = new ArrayList<>();
        for(int point[] : points){
            int lastPos = nonOverlappedInterval.size()-1;
            if(nonOverlappedInterval.isEmpty())
                nonOverlappedInterval.add(point);
            else if(nonOverlappedInterval.get(lastPos)[1] < point[0])
                nonOverlappedInterval.add(point);
            else{
                nonOverlappedInterval.get(lastPos)[0] = 
                Math.max(nonOverlappedInterval.get(lastPos)[0], point[0]);

                nonOverlappedInterval.get(lastPos)[1] = 
                Math.min(nonOverlappedInterval.get(lastPos)[1], point[1]);
            }
        }
        return nonOverlappedInterval.size();
    }
}
