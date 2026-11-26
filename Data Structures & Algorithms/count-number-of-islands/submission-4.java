class Solution {
    private static final int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public int numIslands(char[][] grid) {

        int result = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(grid[row][col] == '1') {
                    dfs(grid, row, col);
                    result += 1;
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, int row, int col) {

        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') return;

        grid[row][col] = '0';
        for(int[] direction: directions) {
            dfs(grid, row + direction[0], col + direction[1]);
        }
    }
}