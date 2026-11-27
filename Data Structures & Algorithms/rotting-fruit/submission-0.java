class Solution {
    
    private static final int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    public int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        int minutes = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(grid[row][col] == 2) {
                    queue.offer(new int[]{row, col});
                    visited[row][col] = true;
                }
            }
        }
        
        while(!queue.isEmpty()) {

            int size = queue.size();

            for(int i = 0; i < size; i++) {
                int[] details = queue.poll();
                int r = details[0];
                int c = details[1];


                for(int[] direction: directions) {
                    int newRow = r + direction[0]; // 1
                    int newCol = c + direction[1]; // 2

                    if(
                        newRow < 0 || newRow >= rows ||
                        newCol < 0 || newCol >= cols ||
                        visited[newRow][newCol] == true || grid[newRow][newCol] == 0
                    ) {
                        continue;
                    }

                    if(!visited[newRow][newCol] && grid[newRow][newCol] == 1) { // false && 1
                        queue.offer(new int[]{newRow, newCol}); // [1,2]
                        visited[newRow][newCol] = true; // T
                    }
                }
            }
            
            if(!queue.isEmpty()) {
                minutes++;
            }  
        }

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(grid[row][col] == 1 && !visited[row][col]) {
                    return -1;
                }
            }
        }

        return minutes;

    }

}
