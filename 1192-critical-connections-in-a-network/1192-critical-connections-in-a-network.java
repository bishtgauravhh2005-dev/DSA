class Solution {
    int time = 0 ;
    public void dfs(int u , ArrayList<Integer> [] graph , int parU , int dt[] , int [] low , List<List<Integer>>ans){
        dt[u] = low[u] = ++time;

        for(int v : graph[u]){
            if(dt[v] == -1){
                dfs(v , graph , u , dt , low , ans); 
                low[u] = Math.min(low[u] , low[v]);

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

        for(int i=0 ; i< n ;i++){
            graph[i] = new ArrayList<>();
        }

        for(List<Integer> x : connections){
            int u = x.get(0);
            int v = x.get(1);

            graph[u].add(v);
            graph[v].add(u);
        }

        int discoverytime[] = new int[n];
        int low[] = new int[n];

        Arrays.fill(discoverytime , -1);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i =0 ;i<n ;i++){
            if(discoverytime[i]== -1){
                dfs(i , graph , -1 , discoverytime , low , ans);
            }
        } 
    return ans;
    }
}