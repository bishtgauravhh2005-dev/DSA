class Solution {
    // public int solve(int[] stones , int i , int diff , int[][] dp , int sum){
    //     if(i== stones.length){
    //         return Math.abs(diff);
    //     }

    //     int index = diff +sum;
    //     if(dp[i][index] != -1){
    //         return dp[i][index];
    //     }
    //     int group1 = solve(stones , i+1 , diff+stones[i] , dp , sum);
    //     int group2 = solve(stones , i+1 , diff-stones[i], dp , sum);

    //     dp[i][index] = Math.min(group1 , group2);
    //     return dp[i][index];
    // }
    // public int lastStoneWeightII(int[] stones) {
    //     int n = stones.length;
    //     int sum =0 ;
    //     for(int s : stones){
    //         sum+=s;
    //     }
    //     int [][] dp = new int[n][2*sum+1];
    //     for(int i =0 ;i< n ;i++){
    //         for(int j =0 ;j<2*sum+1;j++){
    //             dp[i][j]=-1;
    //         }
    //     }
    //     return solve(stones , 0 , 0 , dp , sum);
    // }

     public int lastStoneWeightII(int[] stones) {
       int n = stones.length;
       int sum = 0 ;
       for(int i : stones){
        sum+=i;
       }

       int dp[][] = new int[n+1][2*sum+1];

        for(int d = -sum ;d<=sum ; d++){
            dp[n][d+sum] = Math.abs(d);
        }
       for (int i = n - 1; i >= 0; i--) {

    for (int j = -sum; j <= sum; j++) {

        int ans1 = Integer.MAX_VALUE;
        int ans2 = Integer.MAX_VALUE;

        if (j + stones[i] <= sum) {
            ans1 = dp[i + 1][j + stones[i] + sum];
        }

        if (j - stones[i] >= -sum) {
            ans2 = dp[i + 1][j - stones[i] + sum];
        }

        dp[i][j + sum] = Math.min(ans1, ans2);
    }
}
    return dp[0][sum];
     }
}