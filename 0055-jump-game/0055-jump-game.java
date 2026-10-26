class Solution {
    public boolean solve(int[] nums , int i , Boolean[] dp){
        if(i>=nums.length-1){
            return true;
        }

        if(dp[i] != null){
            return dp[i];
        }

        for(int x = 1 ;x <=nums[i] ; x++){
            if(solve(nums , i+x, dp))
            {
                return dp[i] = true;
            }
        }
        return dp[i] = false;
    }
    public boolean canJump(int[] nums) {
        int n = nums.length;
        Boolean dp[] = new Boolean[n];
        return solve(nums , 0 , dp);
    }
}