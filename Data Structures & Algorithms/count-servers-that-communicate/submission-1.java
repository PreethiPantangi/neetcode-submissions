class Solution {
    public int countServers(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[] rowServerCount = new int[rows];
        int[] colServerCount = new int[cols];
        
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(grid[row][col] == 1) {
                    rowServerCount[row] += 1;
                    colServerCount[col] += 1;
                }
            }
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