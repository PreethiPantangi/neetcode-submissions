class Solution {
    private final int[][] directions = {{0,-1}, {-1,0}, {1,0}, {0,1}};

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        int wordPos = 0;
        boolean[][] visited = new boolean[rows][cols];

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                char ch = word.charAt(wordPos);
                if(dfs(row, col, board, word, wordPos, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(int row, int col, char[][] board, 
                        String word, int wordPos, boolean[][]visited) {

        if(wordPos >= word.length()) return true;

        if(row < 0 || col < 0 || row >= board.length || 
            col >= board[0].length || visited[row][col] == true) return false;

        
        if(board[row][col] != word.charAt(wordPos)) return false;
        
        visited[row][col] = true;
        
        for(int i = 0; i < directions.length; i++) {
            if(
                dfs(row + directions[i][0], col + directions[i][1], board, word, wordPos + 1,visited)
            ) {
                return true;
            }
        }
        visited[row][col] = false;
        return false;
    }
}
