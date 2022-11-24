class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        char[] str = word.toCharArray();
        for(int i = 0; i< board.length; i++) 
            for (int j = 0; j<board[0].length; j++)
                if (board[i][j] == str[0])
                    if(solve(board, visited, str, 0, i, j))
                        return true;
        return false;
    }
    
    private boolean solve(char[][] board, boolean[][] visited, char[] word, int st, int i, int j) {
        if (word.length == st) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]) return false;
        visited[i][j] = true;
        if (board[i][j] == word[st]) {
            if (solve(board, visited, word, st+1, i, j+1) || solve(board, visited, word, st+1, i+1, j) 
                || solve(board, visited, word, st+1, i-1, j) || solve(board, visited, word, st+1, i, j-1)) {
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}