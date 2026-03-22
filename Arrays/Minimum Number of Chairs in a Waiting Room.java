//https://leetcode.com/problems/minimum-number-of-chairs-in-a-waiting-room/

class Solution {
    public int minimumChairs(String s) {
        int maxChairs = 0;
        int peopleInRoom = 0;
        for(char ch : s.toCharArray()){
            if(ch == 'E') maxChairs = Math.max(maxChairs, ++peopleInRoom);
            else peopleInRoom--;
        }
        return maxChairs;
    }
}