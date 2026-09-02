// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(m*k > bloomDay.length) return -1;
        int high = 1, low = (int) 1e9;
        for(int day : bloomDay){
            high = Math.max(high, day);
            low = Math.min(low, day);
        }
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            boolean val = canMakeBouquets(bloomDay, m, k, mid);
            if(val == true){
                ans = mid;
                high = mid-1;
            }else low = mid+1;
        }
        return ans;
    }

    boolean canMakeBouquets(int[] bloomDay, int m, int k, int day){
        int canMake = 0;
        int cnt = 0;
        for(int d : bloomDay){
            if(d <= day){
                cnt++;
                if(cnt == k){
                    canMake++;
                    cnt = 0;
                } 
                continue;
            }
            cnt = 0;
        }
        return canMake >= m;
    }
}