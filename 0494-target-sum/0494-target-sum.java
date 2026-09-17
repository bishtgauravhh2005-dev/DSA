class Solution {
    public int solve(int[] nums ,int sum , int i, int target , int [][]dp  , int totalsum){
        if(i==nums.length){
            if(sum == target){
                return 1;
            }
            return 0 ;
        }
        int index = sum + totalsum;
        if(dp[i][index] != -1){
            return dp[i][index];
        }

        int add = solve(nums , sum + nums[i], i+1 , target , dp , totalsum);

        int sub = solve(nums , sum - nums[i] , i+1 , target , dp , totalsum);

        dp[i][index] = add+sub;
        return add+sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int s = 0;

        for(int x : nums){
            s+=x;
        }
        int dp[][] = new int [nums.length][2*s+1];
        for(int i =0 ;i<nums.length ;i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(nums , 0 , 0 , target , dp , s);
    }
} 