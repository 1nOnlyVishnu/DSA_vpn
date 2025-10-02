class Solution {

    public void dfs(int node,boolean[] visited,ArrayList<ArrayList<Integer>> graph){
        visited[node] = true;

        for(int nbr : graph.get(node)){
            if(!visited[nbr]){
                dfs(nbr,visited,graph);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

        for(int i = 0;i<isConnected.length;i++){
            graph.add(new ArrayList<Integer>());
        }


        for(int i = 0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j] == 1 && i!=j){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i = 0;i<n;i++){
            if(!visited[i]){
                count++;
                dfs(i,visited,graph);
            }
        }
        

        return count;
    }
}