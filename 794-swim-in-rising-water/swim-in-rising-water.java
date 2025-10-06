class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        // Directions for moving up, down, left, right
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        
        // Min-heap (priority queue): stores {time, row, col}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        
        // Visited matrix to avoid revisiting
        boolean[][] visited = new boolean[n][n];
        
        // Start from top-left
        pq.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;

        // Standard Dijkstra loop
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0];  // current max elevation so far
            int r = curr[1];
            int c = curr[2];

            // If we've reached destination, return time
            if (r == n - 1 && c == n - 1) return time;

            // Explore all 4 directions
            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                // Stay within grid bounds
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;

                    // The new cell might have higher elevation
                    // So the time required = max(current time, that cell's height)
                    int newTime = Math.max(time, grid[nr][nc]);

                    // Push into priority queue
                    pq.offer(new int[]{newTime, nr, nc});
                }
            }
        }

        // We should never reach here
        return -1;
    }
}
