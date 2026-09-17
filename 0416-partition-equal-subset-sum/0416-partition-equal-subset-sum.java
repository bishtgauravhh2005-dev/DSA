class Solution {
    public boolean solve(int nums[] , int i , int target , Boolean dp[][]){
        if(target == 0){
            return true;
        }
        if(i == nums.length || target < 0){
            return false;
        }
        if(dp[i][target] != null){
            return dp[i][target];
        }

        boolean ans1 = solve(nums , i+1 , target-nums[i] , dp);
        boolean ans2 = solve(nums , i+1 , target , dp);

        dp[i][target] = ans1||ans2;
        return dp[i][target];
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int x : nums){
            sum+=x;
        }

        if(sum % 2 != 0){
            return false;
        }

        Boolean dp[][] = new Boolean[n][sum/2 +1];
        return solve(nums , 0 , sum/2 , dp);
    }
}