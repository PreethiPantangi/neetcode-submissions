class Solution {
    public boolean isValidSudoku(char[][] board) {
        int length = board.length;
        for(int i = 0; i < length; i++) {
            if(!isRowValid(board[i])) return false;
            if(!isColumnValid(board, length, i)) return false;
        }

        for(int row = 0; row < length; row += 3) {
            for(int col = 0; col < length; col += 3) {
                if(!this.isSubgridValid(board, row, col)) return false;
            }
        }
        return true;
    }

    public boolean isRowValid(char[] row) {
        Set<Character> set = new String(row).
                             chars().
                             filter(c -> c != '.').
                             mapToObj(c -> (char) c).
                             collect(Collectors.toSet());
        long count = new String(row).chars()
            .filter(c -> c != '.')
            .count();
        return set.size() == count;
    }

    public boolean isColumnValid(char[][] board, int length, int colIndex) {
        
        char[] col = new char[length];

        for (int row = 0; row < length; row++) {
            col[row] = board[row][colIndex];
        }
        Set<Character> set = new String(col).
                             chars().
                             filter(c -> c != '.').
                             mapToObj(c -> (char) c).
                             collect(Collectors.toSet());
        long count = new String(col).chars()
            .filter(c -> c != '.')
            .count();
        return set.size() == count;
    }

    public boolean isSubgridValid(char[][]board, int row, int col) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char value = board[row + i][col + j];

                if (value != '.' && !set.add(value)) {
                    return false;
                }
            }
        }

        return true;
    }
}
