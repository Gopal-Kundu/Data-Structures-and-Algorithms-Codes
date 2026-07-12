//https://leetcode.com/problems/valid-tic-tac-toe-state/

/**
 * @param {string[]} board
 * @return {boolean}
 */
var validTicTacToe = function (board) {
    let countX = 0, countO = 0;
    for (let i = 0; i < board.length; i++) {
        for (let j = 0; j < board[i].length; j++) {
            if (board[i].charAt(j) == "X") countX++;
            else if (board[i].charAt(j) == "O") countO++;
        }
    }

    if (countO > countX || countX - countO > 1) return false;
    let xWin = isWin(board, "X");
    let oWin = isWin(board, "O");

    if (xWin == true && oWin == true) return false;

    if (xWin && countX - countO != 1) return false;

    if (oWin && countX != countO) return false;
    return true;
};

let isWin = (board, ch) => {
    //Diagonal
    let leftDiagonal = (board[0][0] == ch && board[1][1] == ch && board[2][2] == ch);
    let rightDiagonal = (board[0][2] == ch && board[1][1] == ch && board[2][0] == ch);

    //Row Col
    let row = 0, col = 0;
    for (let i = 0; i < board.length; i++) {
        let countRow = 0, countCol = 0;
        for (let j = 0; j < board[i].length; j++) {
            if (board[i].charAt(j) == ch) countRow++;
            if (board[j].charAt(i) == ch) countCol++;
        }
        row = Math.max(countRow, row);
        col = Math.max(countCol, col);
    }

    return leftDiagonal || rightDiagonal || (row === 3) || (col === 3);
}