class Solution {
    private static final int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int islands = 0;

        ArrayDeque<int[]> stack = new ArrayDeque<>();

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                
                if(grid[row][col] == '1') {
                    islands += 1;

                    stack.push(new int[]{row, col});
                    grid[row][col] = '0';

                    while(!stack.isEmpty()) {
                        int[] top = stack.pop();

                        int r = top[0];
                        int c = top[1];

                        for (int[] dir : directions) {
                            int newRow = r + dir[0];
                            int newCol = c + dir[1];

                            if (
                                newRow >= 0 && newRow < rows &&
                                newCol >= 0 && newCol < cols &&
                                grid[newRow][newCol] == '1'
                            ) {
                                grid[newRow][newCol] = '0';
                                stack.push(new int[]{newRow, newCol});
                            }
                        }
                    }
                }
            }
        }
        return islands;
    }
}
