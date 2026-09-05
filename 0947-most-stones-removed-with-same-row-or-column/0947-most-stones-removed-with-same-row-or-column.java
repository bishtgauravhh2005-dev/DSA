class Solution {
    // brute force approach :
    // public void dfs(int[][] stones , int curr , boolean[] vis){
    //     vis[curr] = true;

    //     for(int i=0 ;i<stones.length;i++){

    //         int r = stones[curr][0];
    //         int c = stones[curr][1];
    //         if((!vis[i]) && (stones[i][0] == r || stones[i][1] == c) ){
    //             dfs(stones , i , vis);
    //         }
    //     }
    // }
//     public int removeStones(int[][] stones) {
//         int n = stones.length;
//         int g = 0;
//         boolean [] vis = new boolean[stones.length];
//         for(int i=0 ;i<n ;i++){
//             if(!vis[i]){
//                 dfs(stones , i , vis);
//                 g++;
//             }
//         }
//      return n-g;   
//     }
    int parent[];
    int rank[];

    public int find(int x){
        if(parent[x] == x){
            return x;
        }

        return parent[x] = find(parent[x]);
    }
    public void union(int i , int j){
        int parA = find(i);
        int parB = find(j);
        if(parA == parB){
            return;
        }
        if(rank[parA] < rank[parB]){
            parent[parA] = parB;
        }

        else if(rank[parA] > rank[parB]){
            parent[parB] = parA;
        }
        else{
            parent[parB] = parA;
            rank[parA]++;
        }
    }
    public int removeStones(int[][] stones) {
        int n = stones.length;
        parent = new int[n];
        rank = new int[n];

        for(int i =0 ;i < n ;i++){
            parent[i] = i ;
            rank[i] = 0 ;
        }

        for(int i =0 ;i< n ;i ++){
            for(int j = i+1 ; j<n ;j++){
                int r = stones[i][0];
                int c = stones[i][1];

                if(stones[j][0] == r || stones[j][1] == c){
                    union(i,j);
                }
            }
        }

        int g = 0 ;
        for(int i =0 ;i <n ; i++){
            if(find(i) == i){
                g++;
            }
        }
        return n-g;
    }
}