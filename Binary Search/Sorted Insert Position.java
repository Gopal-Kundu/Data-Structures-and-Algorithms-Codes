//https://www.geeksforgeeks.org/problems/search-insert-position-of-k-in-a-sorted-array/1

Sorted Insert Position
class Solution {
    public int searchInsertK(int arr[], int k) {
        // code here
        int start = 0, end = arr.length-1;
        while(start <= end){
            int mid = (start + end)/2;
            if(arr[mid] == k) return mid;
            else if(arr[mid] < k) start = mid+1;
            else if(arr[mid] > k) end = mid-1;
        }
        return start;
    }
};