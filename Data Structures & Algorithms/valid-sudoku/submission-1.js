class Solution {
    /**
     * @param {character[][]} board
     * @return {boolean}
     */
    isValidSudoku(board) {
        let len = board.length;
        for(let i = 0; i < len; i++) {
            if(!this.isRowValid(board[i])) {
                return false;
            }
            if(!this.isColumnValid(board, len, i)) {
                return false;
            }
        }
        for (let row = 0; row < len; row += 3) {
            for (let col = 0; col < len; col += 3) {
                if (!this.isSubgridValid(board, row, col)) {
                    return false;
                }
            }
        }
        return true;
    }

    isRowValid(row) {
        row = row.filter((r) => r !== ".");
        return (new Set(row)).size == row.length;
    }

    isColumnValid(board, rowIndex, colIndex) {
        let i = 0;
        let col = [];
        while(i < rowIndex) {
            col.push(board[i][colIndex]);
            i += 1;
        }
        col = col.filter((r) => r !== ".");
        return (new Set(col)).size == col.length;
    }
    isSubgridValid(board, row, col) {
        let subgrid = [];
        for(let i = 0; i < 3; i++) {
            for(let j = 0; j < 3; j++) {
                const value = board[row + i][col + j];
                if(value !== ".") {
                    subgrid.push(value);
                }
            }   
        }
        return (new Set(subgrid)).size == subgrid.length;
    }
}
