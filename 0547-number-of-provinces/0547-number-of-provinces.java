class Solution {
    public void dfs(int curr , int[][] isConnected , boolean[] vis){
        vis[curr] = true;
        int n = isConnected.length;
        for(int i=0 ;i<n ;i++){
            if(isConnected[curr][i] == 1 && !(vis[i])){
                dfs(i , isConnected , vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean [] vis = new boolean[n];
        int ans = 0;
        for(int i=0 ;i<n ;i++){
            if(!vis[i]){
                dfs(i , isConnected , vis);
                ans++;
            }
        }
        return ans ;
    }
}