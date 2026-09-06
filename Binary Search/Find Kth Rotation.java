//https://www.geeksforgeeks.org/problems/rotation4723/1

class Solution {
    public int findKRotation(int arr[]) {
        // Code here
        int low = 0, high = arr.length-1;
        int idx = -1, hi = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[low] <= arr[mid]){
                if(arr[mid] > hi){
                    idx = mid;
                    hi = arr[mid];
                }
                low = mid+1;
            }else{
                if(arr[high] > hi){
                    idx = high;
                    hi = arr[high];
                }
                high = mid-1;
            }
        }
        return idx == (arr.length-1) ? 0 : idx+1;
    }
}