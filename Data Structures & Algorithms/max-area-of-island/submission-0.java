class Solution {
    private static final int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(grid[row][col] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, row, col));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int row, int col) {

        if(
            row < 0 || row >= grid.length || 
            col < 0 || col >= grid[0].length || 
            grid[row][col] == 0) 
        {
            return 0;
        }

        grid[row][col] = 0;
        int area = 1;
        for(int[] direction: directions) {
            area += dfs(grid, row + direction[0], col + direction[1]);
        }
        return area;
    }
}
