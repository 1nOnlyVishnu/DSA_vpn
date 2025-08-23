class Solution {
    private int[][] grid;
    private final int INF = 1 << 30;

    public int minimumSum(int[][] grid) {
        this.grid = grid;
        int m = grid.length, n = grid[0].length;
        int ans = m * n;

        // Two horizontal splits
        for (int i1 = 0; i1 < m - 1; i1++) {
            for (int i2 = i1 + 1; i2 < m - 1; i2++) {
                ans = Math.min(ans,
                    f(0, 0, i1, n - 1)
                  + f(i1 + 1, 0, i2, n - 1)
                  + f(i2 + 1, 0, m - 1, n - 1));
            }
        }

        // Two vertical splits
        for (int j1 = 0; j1 < n - 1; j1++) {
            for (int j2 = j1 + 1; j2 < n - 1; j2++) {
                ans = Math.min(ans,
                    f(0, 0, m - 1, j1)
                  + f(0, j1 + 1, m - 1, j2)
                  + f(0, j2 + 1, m - 1, n - 1));
            }
        }

        // Mixed splits
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                ans = Math.min(ans,
                    f(0, 0, i, j)
                  + f(0, j + 1, i, n - 1)
                  + f(i + 1, 0, m - 1, n - 1));

                ans = Math.min(ans,
                    f(0, 0, i, n - 1)
                  + f(i + 1, 0, m - 1, j)
                  + f(i + 1, j + 1, m - 1, n - 1));

                ans = Math.min(ans,
                    f(0, 0, i, j)
                  + f(i + 1, 0, m - 1, j)
                  + f(0, j + 1, m - 1, n - 1));

                ans = Math.min(ans,
                    f(0, 0, m - 1, j)
                  + f(0, j + 1, i, n - 1)
                  + f(i + 1, j + 1, m - 1, n - 1));
            }
        }

        return ans;
    }

    // Computes area of the minimal rectangle enclosing all 1’s in subgrid (i1,j1)-(i2,j2)
    private int f(int i1, int j1, int i2, int j2) {
        int x1 = INF, y1 = INF, x2 = -INF, y2 = -INF;
        for (int i = i1; i <= i2; i++) {
            for (int j = j1; j <= j2; j++) {
                if (grid[i][j] == 1) {
                    x1 = Math.min(x1, i);
                    y1 = Math.min(y1, j);
                    x2 = Math.max(x2, i);
                    y2 = Math.max(y2, j);
                }
            }
        }
        return x1 == INF ? 0 : (x2 - x1 + 1) * (y2 - y1 + 1);
    }
}
