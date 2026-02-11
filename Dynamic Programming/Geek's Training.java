//https://www.geeksforgeeks.org/problems/geeks-training/1

class Solution {
    static int[][] memo;
    public int maximumPoints(int mat[][]) {
        // code here
        memo = new int[mat.length][4];
        for(int i = 0; i < memo.length; i++)
            Arrays.fill(memo[i], -1);
        // Start from day 0 with no previous activity (3)
        return solve(0, 3, mat);
    }
    
   private int solve(int day, int last, int[][] mat) {
        int n = mat.length;

        // Base case: if all days are completed
        if (day == n) {
            return 0;
        }
        if(memo[day][last] != -1) 
            return memo[day][last];
        
        int maxPoints = 0;

        // Try all 3 activities: 0 = Running, 1 = Fighting, 2 = Learning
        for (int activity = 0; activity < 3; activity++) {

            // Skip if same activity as previous day
            if (activity == last) continue;

            // Choose this activity and move to next day
            int points = mat[day][activity] + solve(day + 1, activity, mat);

            // Take maximum points
            maxPoints = Math.max(maxPoints, points);
        }

        return memo[day][last] = maxPoints;
    }
}