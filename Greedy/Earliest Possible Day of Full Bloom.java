//https://leetcode.com/problems/earliest-possible-day-of-full-bloom/description/

class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        //Flower Which growtime is high plant it first.
        List<int[]> plantGrow = new ArrayList<>();
        int maxDay = 0;
        int skippedDays = 0;
        for(int i = 0; i < plantTime.length; i++){
            plantGrow.add(new int[]{plantTime[i], growTime[i]});
        }
        Collections.sort(plantGrow, (a,b)->b[1] - a[1]);
        for(int time[] : plantGrow){
            maxDay = Math.max(maxDay, skippedDays + time[0] + time[1]);
            skippedDays = skippedDays + time[0];
        }
        
        return maxDay;
    }
}