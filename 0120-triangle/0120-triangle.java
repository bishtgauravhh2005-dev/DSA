class Solution {
    // public int solve(List<List<Integer>> triangle , int r , int c, int[][] dp){
    //     if(r == triangle.size() -1){
    //         return triangle.get(r).get(c);
    //     }
    //     if(dp[r][c] != -1){
    //         return dp[r][c];
    //     }
    //     int down = solve(triangle , r+1 , c , dp);
    //     int diagonal = solve(triangle, r+1 , c+1 , dp);
    //     int min = Math.min(down , diagonal);

    //     return dp[r][c] = triangle.get(r).get(c) + min;
         
    // }
    // public int minimumTotal(List<List<Integer>> triangle) {
    //     int n = triangle.size();
    //     int [][] dp = new int[n][n];
    //     for(int i = 0 ;i<n ;i++){
    //         Arrays.fill(dp[i] , -1 );
    //     }
    //     return solve(triangle , 0 , 0 , dp);
    // }



    // tabulation
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int c = n-1 ; c >=0 ;c--){
            dp[n-1][c] = triangle.get(n-1).get(c);
        }

        for(int r = n-2 ; r>=0 ;r--){
            for(int c= 0 ;c<=r ; c++){
                int down = dp[r+1][c] ;
                int diagonal = dp[r+1][c+1];

                dp[r][c] = triangle.get(r).get(c) + Math.min(down , diagonal);
            }
        }
        return dp[0][0];


    }
}