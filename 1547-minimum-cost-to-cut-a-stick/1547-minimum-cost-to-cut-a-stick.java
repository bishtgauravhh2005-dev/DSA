class Solution {
    // public int solve(int cuts[] , int left , int right , int [][] dp){
    //     if(right - left < 2){
    //         return 0 ;
    //     }

    //     if(dp[left][right] != -1){
    //         return dp[left][right];
    //     }
    //     int result = Integer.MAX_VALUE;
    //     for(int i = left+1 ; i<= right-1 ; i++){
    //         int cost = cuts[right] - cuts[left] + solve(cuts , left , i , dp) + solve(cuts , i , right , dp);

    //         result = Math.min(cost , result);
    //     }

    //     return dp[left][right] = result ;
    // }
    // public int minCost(int n, int[] cuts) {
    //       Arrays.sort(cuts);

    //     int m = cuts.length;
    //     int[] arr = new int[m + 2];

    //     arr[0] = 0;
    //     arr[m + 1] = n;

    //     for (int i = 0; i < m; i++) {
    //         arr[i + 1] = cuts[i];
    //     }

    //     int dp[][] = new int[m+2][m+2];
    //     for(int i =0 ;i<=m+1 ;i++){
    //         Arrays.fill(dp[i] , -1);
    //     }

    //     return solve(arr, 0, m + 1 , dp);
    
    // }



    /// TABULATION APPROACH :


    public int minCost(int n, int[] cuts) {
          Arrays.sort(cuts);

        int m = cuts.length;
        int[] arr = new int[m + 2];

        arr[0] = 0;
        arr[m + 1] = n;

        for (int i = 0; i < m; i++) {
            arr[i + 1] = cuts[i];
        }

        int dp[][] = new int[m+2][m+2];

        for(int left = m ; left >= 0 ; left--){
            for(int right = left+2 ; right <m+2 ; right++){
                int result = Integer.MAX_VALUE;

                for(int k = left+1; k<right ; k++){
                    int cost = (arr[right] - arr[left]) + dp[left][k] + dp[k][right];

                    result = Math.min(cost , result);
                }
                dp[left][right] = result;
            }
        }
        return dp[0][m+1];
    
    }

}