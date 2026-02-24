// https://www.geeksforgeeks.org/problems/square-root/1
class Solution {
    int floorSqrt(int n) {
        // code here
        int start = 1, end = n;
        int possibleAns = 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            int sq = mid*mid;
            if(sq == n) return mid;
            else if(sq < n){
                possibleAns = mid;
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return possibleAns;
    }
}