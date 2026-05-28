//https://leetcode.com/problems/game-of-life/description/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public void gameOfLife(int[][] board) {
        //For in place upgrade means no extra space. 
        //If new value is same then keep same
        //If new value diffrs than old then change it. 1 for -1 and 0 for 2
        int[][] ans = new int[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                int alive_cells = neighbourCellsAlive(board, row, col);
                if (board[row][col] == 1) {
                    if (alive_cells < 2)
                        board[row][col] = -1;
                    else if (alive_cells == 2 || alive_cells == 3)
                        board[row][col] = 1;
                    else if (alive_cells > 3)
                        board[row][col] = -1;
                } else{
                    if (alive_cells == 3)
                        board[row][col] = 2;
                }
            }
        }

        //Final conversion

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 2)
                    board[i][j] = 1;
                else if(board[i][j] == -1)
                    board[i][j] = 0;
            }
        }
    }

    int neighbourCellsAlive(int[][] board, int x, int y) {
        int[][] cood = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 },
                { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };
        int alive_cells = 0;
        for (int r = 0; r < cood.length; r++) {
            if ((cood[r][0] + x) >= 0 && (cood[r][0] + x) < board.length
                    && (cood[r][1] + y) >= 0 && (cood[r][1] + y) < board[0].length) {
                int row = cood[r][0] + x, col = cood[r][1] + y;
                if (board[row][col] == 1 || board[row][col] == -1)
                    alive_cells++;
            }
        }
        return alive_cells;
    }
}