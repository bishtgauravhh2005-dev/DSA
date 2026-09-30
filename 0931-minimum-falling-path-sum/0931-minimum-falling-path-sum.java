class Solution {
    // public int solve(int[][] matrix , int r , int c , int[][] dp){
    //     if(c<0 || c >= matrix[0].length){
    //         return Integer.MAX_VALUE ;
    //     }

    //     if(r == matrix.length - 1){
    //         return matrix[r][c];
    //     }

    //     if(dp[r][c] != -1){
    //         return dp[r][c];
    //     }

        
    //         int ans1 =  solve(matrix , r+1 , c-1, dp);
    //         int ans2 =  solve(matrix , r+1 , c  , dp);
    //         int ans3 =  solve(matrix , r+1 , c+1, dp);


    //         int min = Math.min(ans1 , Math.min(ans2 , ans3));
    //         if(min == Integer.MAX_VALUE){
    //             return Integer.MAX_VALUE;
    //         }

    //     return dp[r][c] = matrix[r][c] + min;
    // }
    // public int minFallingPathSum(int[][] matrix) {
    //     int result = Integer.MAX_VALUE ;
    //     int n = matrix.length;
    //     int m = matrix[0].length;
    //     int [][] dp = new int[n][m];
    //     for(int i =0 ;i< n ;i++){
    //         Arrays.fill(dp[i] , -1);
    //     }
        
    //     for(int i =0 ;i<matrix.length ; i++){

    //         result = Math.min(result , solve(matrix , 0 , i , dp));
    //     }
    //     return result;
    // }


    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] dp = matrix[n-1].clone();
        for(int r = n-2 ; r>=0 ;r--){
            int curr[] = new int[n];

            for(int c =0 ; c< n ; c++){
                int left = (c>0) ? dp[c-1] : Integer.MAX_VALUE;
                int bottom = dp[c];
                int right = (c < n-1) ? dp[c+1] : Integer.MAX_VALUE;

                curr[c] = matrix[r][c] + Math.min(left , Math.min(right , bottom));
            }
            dp = curr;
        }
        int result = Integer.MAX_VALUE;
        for(int val : dp){
            result = Math.min(result , val);
        }

        return result;
    }
}