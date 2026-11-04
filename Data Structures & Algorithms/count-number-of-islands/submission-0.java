class Solution {
    public int numIslands(char[][] grid) {
        int[][] directions = {{0,-1}, {0,1}, {-1,0}, {1,0}};

        int rows = grid.length;
        int cols = grid[0].length;
        int result = 0;

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(grid[row][col] == '1') {
                    dfs(row, col, grid, directions);
                    result += 1;
                }
            }
        }
        return result;
    }

    public void dfs(int row, int col, char[][] grid, int[][] directions) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0') return;

        grid[row][col] = '0';
        for(int i = 0; i < directions.length; i++) {
            dfs(row + directions[i][0], col + directions[i][1], grid, directions);
        }

    }
}
