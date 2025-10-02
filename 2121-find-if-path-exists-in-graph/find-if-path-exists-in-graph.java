class Solution {

    public void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> graph) {
        visited[node] = true;
        for (int nbr : graph.get(node)) {
            if (!visited[nbr]) {
                dfs(nbr, visited, graph);
            }
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph (undirected)
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Run DFS
        dfs(source, visited, graph);

        return visited[destination];
    }
}
