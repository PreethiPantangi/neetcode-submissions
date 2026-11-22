class Solution {
    int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int islands = 0;

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(grid[row][col] != '0') {
                    dfs(grid, row, col);
                    islands += 1;
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, int row, int col) {

        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') return;

        grid[row][col] = '0';

        for(int i = 0; i < directions.length; i++) {
            dfs(grid, row + directions[i][0], col + directions[i][1]);
        }

    }
}
