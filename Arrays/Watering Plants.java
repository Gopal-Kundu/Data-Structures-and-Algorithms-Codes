//https://leetcode.com/problems/watering-plants/description/

class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int total = 0;
        int refil = capacity;
        for(int i = 0; i < plants.length; i++){
            if(capacity < plants[i]){
                total += i + (i+1);
                capacity = refil - plants[i];
            }else{
                capacity -= plants[i];
                total++;
            }
        }
        return total;
    }
}
