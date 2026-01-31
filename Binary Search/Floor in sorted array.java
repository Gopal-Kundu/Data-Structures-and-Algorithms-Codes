//https://www.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1

class Solution {
    public int findFloor(int[] arr, int x) {
        // code here
        int start = 0, end = arr.length-1;
        int ans = -1;
        while(start <= end){
            int mid = (start + end)/2 ;
            if(arr[mid] <= x){
                ans = mid;
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        
        return ans;
    }
}
