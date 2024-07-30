class Solution {
    int R;
    int C;
    char[][] checked;
    int[][] solutions = new int[][] {
            { 0, 1 },
            { 1, 0 },
            { -1, 0 },
            { 0, -1 },
    };

    boolean found = false;

    public boolean exist(char[][] board, String word) {
        R = board.length;
        C = board[0].length;
        checked = grid(R, C);

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                search(board, word, 0, i, j);
            }
        }

        return found;

    }

    void search(char[][] board, String word, int index, int row, int col) {
        if(board[row][col] != word.charAt(index))
            return;

        if(index == word.length() - 1) {
            found = true;
            return;
        }

        checked[row][col] = 'X';

        for(int[] sol : solutions) {
            int newX = row + sol[0];
            int newY = col + sol[1];

            if(0 <= newX && newX < R 
                && 0 <= newY && newY < C 
                && checked[newX][newY] != 'X') {
                
                search(board, word, index + 1, newX, newY);

            }
        }

        checked[row][col] = '.';

    }

    char[][] grid(int row, int col) {
        char[][] grid = new char[row][col];
        for (char[] r : grid) {
            Arrays.fill(r, '.');
        }
        return grid;
    }
}