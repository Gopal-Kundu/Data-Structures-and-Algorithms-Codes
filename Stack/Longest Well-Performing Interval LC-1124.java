// https://leetcode.com/problems/longest-well-performing-interval/description/

//Brute Foce
class Solution {
    public int longestWPI(int[] hours) {
        int maxLen = 0;
        for (int i = 0; i < hours.length; i++) {
            int T = 0, N = 0;
            for (int j = i; j < hours.length; j++) {
                if (hours[j] > 8) T++;
                else N++;
                if (T > N) {
                    maxLen = Math.max(j - i + 1, maxLen);
                }

            }
        }
        return maxLen;
    }
}

//Optimized approach