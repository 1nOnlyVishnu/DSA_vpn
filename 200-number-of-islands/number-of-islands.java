class Pair{
    int first;
    int second;

    public Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];

        int count = 0;

        for(int row = 0;row<n;row++){
            for(int col = 0;col < m;col++){
                if(visited[row][col] == 0 && grid[row][col] == '1'){
                    count++;
                    bfs(row,col,visited,grid);
                }
            }
        }

return count;
    }

    private void bfs(int ro,int co,int[][] visited,char[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        visited[ro][co] = 1;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(ro,co));

        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;

            q.remove();


            for(int delrow = -1;delrow <=1;delrow++){
                for(int delcol =-1;delcol<=1;delcol++){
                    int nrow = row + delrow;
                    int ncol = col + delcol;

                    if((delrow == 0 || delcol == 0) && nrow>=0 && nrow < n && ncol>=0 && ncol<m && grid[nrow][ncol] == '1' && visited[nrow][ncol] == 0){
                        visited[nrow][ncol] = 1;
                        q.add(new Pair(nrow,ncol));
                    }
                }
            }
        }

        
    }
}