//https://leetcode.com/problems/k-closest-points-to-origin/

class pointsWithDistance{
    int distance = 0;
    int coordinate[];
    pointsWithDistance(int[] point){
        coordinate = point;
        distance = point[0]*point[0] + point[1]*point[1];
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<pointsWithDistance> pq = 
        new PriorityQueue<>((a,b)->Integer.compare(a.distance, b.distance));

        for(int coordinate[] : points){
            pq.offer(new pointsWithDistance(coordinate));
        }
        List<int[]> answer = new ArrayList<>();
        while(k != 0){
            answer.add(pq.poll().coordinate);
            k--;
        }
        return answer.toArray(new int[0][]);
    }
}