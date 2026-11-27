class Solution {
    public int countServers(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[] rowServerCount = new int[rows];
        for(int i = 0; i < rows; i++) {
            int[] row = grid[i];
            int count = 0;
            for(int j = 0; j < cols; j++) {
                count += row[j];
            }
            rowServerCount[i] = count;
        }

        int[] colServerCount = new int[cols];
        for(int i = 0; i < cols; i++) {
            int count = 0;
            for(int j = 0; j < rows; j++) {
                count += grid[j][i];
            }
            colServerCount[i] = count;
        }

        int result = 0;

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(grid[row][col] == 1 && (rowServerCount[row] > 1 || colServerCount[col] > 1)) {
                    result += 1;
                }
            }
        }

        return result;
    }
}