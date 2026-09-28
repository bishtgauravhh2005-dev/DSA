class Solution {

    // MEMOIZATION :
    // public int solve(int[][] arr , int i , int j , int[][] dp){
    //     if(i >= arr.length|| j >= arr[0].length){
    //         return 0;
    //     }
    //     if(arr[i][j] == 1){
    //         return 0;
    //     }

    //     if(i == arr.length-1 && j == arr[0].length-1 ){
    //         return 1;
    //     }
    //     if(dp[i][j] != -1){
    //         return dp[i][j];
    //     }

    //     int ans1 = solve(arr , i+1 , j , dp);
    //     int ans2 = solve(arr , i , j+1 , dp);

    //     return dp[i][j] = ans1 + ans2;
    // }
    // public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    //     int n = obstacleGrid.length;
    //     int m = obstacleGrid[0].length;
    //     int[][] dp = new int[n+1][m+1];
    //     for(int i=0 ;i<n+1 ;i++){
    //         Arrays.fill(dp[i] , -1);
    //     }
    //     return solve(obstacleGrid , 0 ,0,dp);
    // }



    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        
        if(obstacleGrid[0][0] == 1){
            return 0;
        }

        dp[0][0] = 1;
        

        for(int i=0 ;i<n ; i++){
            for(int j=0 ; j<m ;j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }
                if (i == 0 && j == 0) {
                    continue;
                }
                int left = 0;
                int up =0;
                if(i>0){
                     up = dp[i-1][j];
                }
                if(j>0){
                    left = dp[i][j-1];
                }
                dp[i][j] = left + up;
            }
        }
        return dp[n-1][m-1];
    }
}