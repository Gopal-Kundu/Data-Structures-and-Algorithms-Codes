//https://leetcode.com/problems/find-k-closest-elements/

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        List<Integer> res = new ArrayList<>();

        if (n < k) return res;

        int i = 0;
        int sum = 0, minSum;
        int wi = 0, wj = k - 1;

        // Calculate the sum for the first window
        for (int j = 0; j < k; j++) {
            sum += Math.abs(arr[j] - x);
        }

        minSum = sum;

        // Slide the window across the array
        for (int j = k; j < n; j++) {
            sum += Math.abs(arr[j] - x);
            sum -= Math.abs(arr[i] - x);

            if (sum < minSum) {
                wi = i + 1;
                wj = j;
                minSum = sum;
            }

            i++;
        }

        // Collect the elements from the best window
        for (int m = wi; m <= wj; m++) {
            res.add(arr[m]);
        }

        return res;
    }
}