//https://leetcode.com/problems/alternating-groups-ii/description/

class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int i = 0;
        int cnt = 0;
        int n = colors.length;
        for(int j = 1; j < colors.length + k - 1; j++){
            if(colors[(j-1)%n] == colors[j%n]) i = j;
            if(j - i + 1 == k){
                cnt++;
                i++;
            }
        }
        return cnt;
    }
}