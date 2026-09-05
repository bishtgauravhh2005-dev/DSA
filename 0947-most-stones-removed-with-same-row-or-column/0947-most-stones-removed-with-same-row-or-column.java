class Solution {
    public void dfs(int[][] stones , int curr , boolean[] vis){
        vis[curr] = true;

        for(int i=0 ;i<stones.length;i++){

            int r = stones[curr][0];
            int c = stones[curr][1];
            if((!vis[i]) && (stones[i][0] == r || stones[i][1] == c) ){
                dfs(stones , i , vis);
            }
        }
    }
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int g = 0;
        boolean [] vis = new boolean[stones.length];
        for(int i=0 ;i<n ;i++){
            if(!vis[i]){
                dfs(stones , i , vis);
                g++;
            }
        }
     return n-g;   
    }
}