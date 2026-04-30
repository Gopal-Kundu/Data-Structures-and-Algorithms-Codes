//https://leetcode.com/problems/eliminate-maximum-number-of-monsters/description/

class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        ArrayList<Double> list = new ArrayList<>();
        for(int i = 0; i < dist.length; i++){
            list.add((dist[i]/speed[i])*1.0);
        }
        Collections.sort(list);
        int minute  = 0;
        int monstersKilled = 0;
     
        for(double timeTakeToMonsterReach : list){
            if(timeTakeToMonsterReach > 0){
                monstersKilled++;
            }else if(timeTakeToMonsterReach <= 0) break;
            minute++;
        }
        return monstersKilled;
    }
}