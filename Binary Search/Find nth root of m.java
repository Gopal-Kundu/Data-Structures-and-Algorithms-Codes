//https://www.geeksforgeeks.org/problems/find-nth-root-of-m5843/1

class Solution {
    public int nthRoot(int n, int m) {
        // code here
        if(m == 0) return 0;
        int low = 1,high = m;
        while(low <= high){
            int mid = low + (high - low)/2;
            int val = findExp(mid, n);
            if(val == m) return mid;
            else if(val < m) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
    
    int findExp(int n, int m){
        if(n == 0) return 0;
        if(n == 1) return 1;
        int ans = 1;
        while(m > 0){
            if(m%2 == 1){
                ans *= n;
                m--;
            }else{
                n*=n;
                m = m/2;
            }
        }
        return ans;
    }
}