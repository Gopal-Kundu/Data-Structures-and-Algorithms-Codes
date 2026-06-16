//https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/description/

class Solution {
    public int minimumRecolors(String blocks, int k) {
        int i = 0, j = 0;
        int w = 0;
        while(j < k){
            if(blocks.charAt(j) == 'W') w++;
            j++;
        }
        int ans = w;
        while(j < blocks.length()){
            if(blocks.charAt(j) == 'W') w++;
            if(blocks.charAt(i) == 'W') w--;
            i++; j++;
            ans = Math.min(w, ans);
        }
        return ans;
    }
}