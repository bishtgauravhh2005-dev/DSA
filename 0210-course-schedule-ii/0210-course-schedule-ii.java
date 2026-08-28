class Solution {
    public boolean dfs(int curr , ArrayList<Integer>[] graph ,boolean[] vis , boolean pathvis[], Stack<Integer> s){
        vis[curr] = true;
        pathvis[curr] = true;
        for(int neigh : graph[curr]){
            if(pathvis[neigh]){
                return true;
            }
            if(!vis[neigh]){
                if(dfs(neigh, graph , vis ,pathvis, s)){
                    return true;
                }
            }
        }
        pathvis[curr] =false;
        s.push(curr);
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        int n = numCourses;
        for(int i=0 ;i<n;i++){
            graph[i] = new ArrayList<>();
        }

        for(int []edge : prerequisites){
            int u = edge[0];
            int v = edge[1];
            graph[v].add(u);
        }
        boolean vis[] = new boolean[n];
        boolean pathvis[] = new boolean[n];
        Stack<Integer> s = new Stack<>();
        for(int i=0 ;i<n;i++){
            if(!vis[i]){
                if(dfs(i,graph, vis,pathvis,  s)){
                    return new int[0];
                }
            }
        }
        int ans[] = new int[n];
        int i=0;
        while(!s.isEmpty()){
            ans[i++] = (s.pop());
        }
        return ans;
    }
}