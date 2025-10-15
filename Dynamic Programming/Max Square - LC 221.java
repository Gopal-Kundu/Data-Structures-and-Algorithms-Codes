// https://leetcode.com/problems/maximal-square/description

class Solution {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        //Dp array is for largest sqaure we can obtain at that row,col
        int dp[][] = new int[row][col];
        int maxSquare = 0;
        //Initially we can get 1 for all 1st row and 1st col if there is 1 and for 0 we get nothing.
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(i == 0 || j == 0){
                    if(matrix[i][j] == '1')
                        dp[i][j] = 1;
                    else if(matrix[i][j] == '0')
                        dp[i][j] = 0;
                }
                //For else portion the largest square we get is, (min of up, left and diagonal) + 1 bcz, if all of them 1 that mean i can form 2 length square, if either of them 2 or 1 we cosider 1 bcz there not enough square.
                else if(matrix[i][j] == '0') continue; //Skip that part.
                else{
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]))+1;
                }
                maxSquare = Math.max(dp[i][j], maxSquare); //To track max square.
            }
        }
        return maxSquare*maxSquare;
        
    }
}