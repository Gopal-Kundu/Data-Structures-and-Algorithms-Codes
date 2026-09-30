//https://leetcode.com/problems/kth-missing-positive-number/description/

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int missing = arr[mid] - (mid + 1);
            if (missing <= k)
                low = mid + 1;

            else
                high = mid - 1;
        }
        int more = k + high + 1;
        return arr[high] + more;
    }
}
