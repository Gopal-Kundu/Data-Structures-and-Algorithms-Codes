//https://www.geeksforgeeks.org/problems/subset-sum-problem-1/

class Solution {

    static Boolean memo[][];
     Boolean isSubsetSum(int arr[], int sum) {
        // code here
        memo = new Boolean[arr.length][sum+1];
        return solve(arr, sum, 0);
    }
    
    boolean solve(int arr[], int target, int idx){
        if(target == 0) return true;
        if(idx == arr.length) return false;
        
        if(memo[idx][target] != null) return memo[idx][target];
        
        boolean take = false;
        if(target - arr[idx] >= 0) 
            take = solve(arr, target - arr[idx], idx+1);
        
        boolean notTake = solve(arr, target, idx+1);
        
        return memo[idx][target] = take || notTake;
    }
}