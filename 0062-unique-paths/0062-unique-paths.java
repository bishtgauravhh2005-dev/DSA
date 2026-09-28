class Solution {
    // public int solve(int m , int n , int i , int j , int[][] dp){
    //     if(i >= m || j >= n){
    //         return 0;
    //     }
    //     if(i == m-1 && j == n - 1){
    //         return 1;
    //     }

    //     if(dp[i][j] != -1){
    //         return dp[i][j];
    //     }
    //     int ans1 = solve(m , n , i+1 , j , dp);

    //     int ans2 = solve(m , n , i, j+1 , dp);

    //     return dp[i][j] = ans1+ans2;
    // }
    // public int uniquePaths(int m, int n) {
    //     int dp[][] = new int[m][n];

    //     for(int i = 0 ;i< m ;i++){
    //         Arrays.fill(dp[i] , -1);
    //     }
    //     return solve(m , n , 0 , 0 , dp);
    // }


    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        dp[0][0]=1;
        for(int i=0 ; i< m ;i++){
            dp[i][0] = 1;
        }

        for(int j =0 ;j<n ;j++){
            dp[0][j] = 1;
        }
        for(int i = 1 ;i< m ;i++){
           for(int j =1 ;j<n ;j++){
            int ans1 = dp[i-1][j];
            int ans2 = dp[i][j-1];

            dp[i][j] = ans1 + ans2;
           }
        }
        return dp[m-1][n-1];
        
    }
}