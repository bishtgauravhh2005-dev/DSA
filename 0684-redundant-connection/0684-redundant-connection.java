class Solution {
    public boolean dfs(int curr , int dest , ArrayList<Integer> []graph , boolean vis[]){
        
        if(curr == dest){
            return true;
        }
        vis[curr] = true;
        for(int neigh : graph[curr]){
            if(!vis[neigh]){
                if(dfs(neigh , dest , graph , vis)){
                    return true;
                }
            }
        }
        return false;
    }
    public int[] findRedundantConnection(int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[edges.length +1];
        int n = edges.length;
        for(int i=1 ;i<=n;i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            boolean vis[] = new boolean[n+1];
            int u = edge[0];
            int v = edge[1];

            if(dfs(u,v , graph , vis)){
                return edge;
            }

            graph[u].add(v);
            graph[v].add(u);
        }
    return new int[0];
    }
}