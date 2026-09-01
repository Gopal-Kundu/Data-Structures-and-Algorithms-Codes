//https://www.geeksforgeeks.org/problems/koko-eating-bananas/1

class Solution {
    public int kokoEat(int[] arr, int k) {
        // code here
        int high = 1;
        for(int pile : arr) high = Math.max(high, pile);
        
        int low = 1; //Qs says eat one pile per hour minimum.
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(timeTook(arr, mid) <= k){
                ans = mid;
                high = mid-1;
            }else low = mid+1;
        }
        return ans;
    }
    
    int timeTook(int piles[], int k){
        int ans = 0;
        for(int pile : piles){
            ans += Math.ceil((float)pile/k);
        }
        return ans;
    }
}
