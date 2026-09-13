class Solution {
    public int climb(int[] cost , int n , int i , int [] dp){
        if(i>n){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int x = cost[i] + climb(cost , n , i+1 , dp);
        int y = cost[i] + climb(cost , n , i+2 , dp);

        dp[i] =  Math.min(x , y);
        return dp[i];
    }
    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length];
        Arrays.fill(dp , -1);
        return Math.min(climb(cost , cost.length-1 , 0 , dp), climb(cost , cost.length-1 , 1, dp));
    }
}