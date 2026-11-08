class Solution {
    int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public int numIslands(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        
        int islands = 0;
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(grid[row][col] == '1') {
                    dfs(grid, row, col, rows, cols);
                    islands += 1;
                } 
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, int row, int col, int rows, int cols) {
        if(row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0') return;

        grid[row][col] = '0';
        for(int i = 0; i < directions.length; i++) {
            dfs(grid, row + directions[i][0], col + directions[i][1], rows, cols);
        }
    }
}
