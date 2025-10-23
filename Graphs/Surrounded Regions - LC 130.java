//https://leetcode.com/problems/surrounded-regions/description/

class Solution {
    public void solve(char[][] board) {
        //Just call DFS from boundary and mark as any other alphabate other than O and then replace all O with X which are not that alphabate and return by replacing that alphabate with O
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O')
                DFS(board, 0, i);
            if (board[board.length-1][i] == 'O')
                DFS(board, board.length-1, i);
        }

        for(int i = 0; i < board.length; i++){
            if (board[i][0] == 'O')
                DFS(board, i, 0);
            if (board[i][board[0].length-1] == 'O')
                DFS(board, i, board[0].length-1);
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'p')
                    board[i][j] = 'O';
                else if(board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }

    void DFS(char[][] board, int row, int col) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != 'O')
            return;
        board[row][col] = 'p'; //Marking visited
        DFS(board, row - 1, col);
        DFS(board, row, col - 1);
        DFS(board, row + 1, col);
        DFS(board, row, col + 1);
    }
}