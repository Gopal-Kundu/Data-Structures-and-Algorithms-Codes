//https://leetcode.com/problems/nearest-available-drone/description/

class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int md = (int)1e9, idx = (int)1e9;
        int i = 0;
        for(int[] drone : drones){
            int dis = Math.abs(drone[0] - target[0]) +
                        Math.abs(drone[1] - target[1]);
            if(dis <= drone[2]){
                if(dis < md){
                    md = dis;
                    idx = i;
                }
            }
            i++;
        }

        return idx == (int)1e9 ? -1 : idx;
    }
}