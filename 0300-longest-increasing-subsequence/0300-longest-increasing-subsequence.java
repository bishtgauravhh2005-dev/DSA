class Solution {
    // public int solve(int[]nums , int prev , int i , int[][] dp){
    //     if(i == nums.length){
    //         return 0;
    //     }

    //     if(dp[i][prev+1] != -1){
    //         return dp[i][prev+1];
    //     }

    //     int take = 0 ;
    //     if(prev == -1 || nums[prev] < nums[i]){
    //         take = 1 + solve(nums , i , i+1 , dp);
    //     }

    //     int skip = solve(nums , prev , i+1 , dp);

    //     return dp[i][prev+1] = Math.max(take , skip);
    // }
    // public int lengthOfLIS(int[] nums) {
    //     int dp[][] = new int[nums.length+1][nums.length+1];

    //     for(int i=0 ;i<nums.length+1 ; i++){
    //         Arrays.fill(dp[i] , -1);
    //     }

    //     return solve(nums , -1 , 0 , dp);
    // }

// Tabulation ::
    public int lengthOfLIS(int[] nums) {
      int[] dp = new int[nums.length];

      Arrays.fill(dp , 1);
      int maxlis = 0 ;
      for(int i =0;i < nums.length ; i++){
        for(int j = 0 ;j<i ; j++){
            if(nums[j] < nums[i]){
                dp[i] = Math.max(dp[i] , dp[j]+1);
            }
        }
        maxlis = Math.max(dp[i] , maxlis);
      }
      return maxlis;
    }
}