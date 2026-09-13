class Solution {
    // public int solve(int i , int [] nums){
    //     if(i<0){
    //         return 0 ;
    //     }

    //     int rob = nums[i] + solve(i-2 , nums);
    //     int skip = solve(i-1 , nums);

    //     return Math.max(rob , skip);
    // }
    // public int rob(int[] nums) {
    //     return solve (nums.length-1 , nums);
    // }


   // Memoixation:
    // public int solve(int i , int[] nums , int[] dp){
    //     if(i<0){
    //         return 0;
    //     }

    //     if(dp[i] != -1){
    //         return dp[i];
    //     }
    //     int rob = nums[i] + solve(i-2, nums , dp);
    //     int skip = solve(i-1 , nums , dp);

    //     dp[i] = Math.max(rob , skip);

    //     return dp[i];
    // }
    // public int rob (int []nums){
    //     int dp[] = new int[nums.length];
    //     Arrays.fill(dp , -1);
    //     return solve(nums.length-1 , nums , dp);
    // }



    // tabulation:

    public int rob(int[] nums){
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int dp[] = new int[n];

        Arrays.fill(dp,-1);

        dp[0] = nums[0];
        dp[1] = Math.max(nums[1] , dp[0]);

        for(int i = 2; i<n ;i++){
            int rob = nums[i] + dp[i-2];
            int skip = dp[i-1];

            dp[i] = Math.max(rob , skip);
        }

        return dp[n-1];
    }
}