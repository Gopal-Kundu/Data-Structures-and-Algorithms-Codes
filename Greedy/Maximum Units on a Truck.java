//https://leetcode.com/problems/maximum-units-on-a-truck/

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b)-> b[1] - a[1]);
        int unit = 0;
        for(int[] boxes : boxTypes){
            if(truckSize > boxes[0]){
                unit += boxes[0]*boxes[1];
                truckSize-=boxes[0];
            }else{
                unit += truckSize * boxes[1]; 
                break;
            }
        }
        return unit;

    }
}