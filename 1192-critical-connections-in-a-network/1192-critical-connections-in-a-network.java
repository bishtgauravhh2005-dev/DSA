class Solution {
    // tarjan's algorithm
    int time = 0;
    public void dfs(int u ,ArrayList<Integer> [] graph ,int parU , int[] dt , int[] low  ,List<List<Integer>> ans){
        low[u] = ++time;
        dt[u] = low[u];
        for(int v : graph[u]){
            if(dt[v] == -1){
                dfs(v , graph , u , dt , low , ans);
                low[u] = Math.min(low[v] , low[u]);

                if(low[v] > dt[u]){
                    ans.add(Arrays.asList(u,v));
                }
            }

            else if(v != parU){
                low[u] = Math.min(low[u] , dt[v]);
            }
        }
        
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<Integer> [] graph = new ArrayList[n];

        for(int i =0 ;i<n ;i++){
            graph[i] = new ArrayList<>();
        }

        for(List<Integer> x : connections){
            int u = x.get(0);
            int v = x.get(1);

            graph[u].add(v);
            graph[v].add(u);
        }
        int dt[] = new int[n]; // discovery time
        int low[] = new int[n];
        Arrays.fill(dt , -1);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i =0 ;i <n ;i++){
            if(dt[i] == -1){
                dfs(i , graph , -1 , dt , low , ans);
            }
        }
    return ans ;
    }
}