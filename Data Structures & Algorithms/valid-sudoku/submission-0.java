class Solution {
    public boolean isValidSudoku(char[][] board) {

        for (int row = 0; row < 9; row++) {
            if (!isValid(board[row])) return false;
        }

        for (int col = 0; col < 9; col++) {
            char[] colValues = new char[9];

            for (int row = 0; row < 9; row++) {
                colValues[row] = board[row][col];
            }

            if (!isValid(colValues)) return false;
        }


        return isEachGridValid(board);

    }

    private boolean isEachGridValid(char[][] board) {
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {

                boolean[] seen = new boolean[10];

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {

                        char value = board[row + i][col + j];

                        if (value != '.') {
                            int num = value - '0';

                            if (seen[num]) return false;

                            seen[num] = true;
                        }
                    }
                }
            }
        }
        return true;
    }

    private boolean isValid(char[] values) {

        boolean[] seen = new boolean[10];

        for(char value: values) {
            if(value != '.') {
                int num = value - '0';

                if(seen[num]) return false;
                seen[num] = true;   
            }
        }
        return true;
    }
}
