class Solution {
    int n, m;
    
    public void fill(char[][] grid) {
        n = grid.length;
        m = grid[0].length;

        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 'O') dfs(grid, i, 0);
            if (grid[i][m - 1] == 'O') dfs(grid, i, m - 1);
        }

        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 'O') dfs(grid, 0, j);
            if (grid[n - 1][j] == 'O') dfs(grid, n - 1, j);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'O') {
                    grid[i][j] = 'X';
                } else if (grid[i][j] == 'S') {
                    grid[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] != 'O') return;

        grid[i][j] = 'S';

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
