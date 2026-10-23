//https://leetcode.com/problems/count-zero-request-servers/

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = queries.length;
        int[][] q = new int[m][2];
        for (int i = 0; i < m; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }
        Arrays.sort(q, (a, b) -> a[0] - b[0]);
        Arrays.sort(logs, (a, b) -> a[1] - b[1]);

        int left = 0, right = 0, activeServers = 0;
        int len = logs.length;
        int freq[] = new int[n + 1]; //Total Servers
        int ans[] = new int[m];
        for (int i = 0; i < m; i++) {
            int end = q[i][0], start = end - x;
            while (right < len && logs[right][1] <= end) {
                int server = logs[right][0];
                if (freq[server] == 0)
                    activeServers++;
                freq[server]++;
                right++;
            }
            while (left < right && logs[left][1] < start) {
                int server = logs[left][0];
                freq[server]--;
                if (freq[server] == 0)
                    activeServers--;
                left++;
            }
            ans[q[i][1]] = n - activeServers;
        }
        return ans;
    }
}