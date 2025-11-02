class Solution {
    // cell states
    private static final int EMPTY = 0;
    private static final int GUARD = 1;
    private static final int WALL  = 2;
    private static final int WATCHED = 3; // marked as guarded/watched

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] state = new int[m][n];

        // place guards
        for (int[] g : guards) {
            state[g[0]][g[1]] = GUARD;
        }
        // place walls
        for (int[] w : walls) {
            state[w[0]][w[1]] = WALL;
        }

        // directions: up, down, left, right
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        // for every guard, extend in all 4 directions and mark watched cells
        for (int[] g : guards) {
            int r = g[0], c = g[1];
            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                while (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    if (state[nr][nc] == WALL || state[nr][nc] == GUARD) {
                        break; // stop when we hit a wall or another guard
                    }
                    if (state[nr][nc] == EMPTY) {
                        state[nr][nc] = WATCHED; // mark watched
                    }
                    nr += d[0];
                    nc += d[1];
                }
            }
        }

        // count unguarded cells: those that are EMPTY (never marked)
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (state[i][j] == EMPTY) count++;
            }
        }

        return count;
    }

}