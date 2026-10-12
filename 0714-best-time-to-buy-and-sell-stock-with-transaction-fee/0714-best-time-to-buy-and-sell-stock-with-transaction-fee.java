class Solution {
    public int solve(int[] prices , int fee , int i , int canBuy , int dp[][]){
        if(i == prices.length){
            return 0;
        }
        if(dp[i][canBuy] != -1){
            return dp[i][canBuy];
        }
        if(canBuy == 1){
            int buy = -prices[i] + solve(prices , fee , i+1 , 0 , dp);

            int skip = solve(prices , fee , i+1 , 1 , dp);
            return dp[i][canBuy] = Math.max(buy , skip);
        }
        else{
            int sell = prices[i] - fee + solve(prices , fee , i+1 , 1 , dp);
            int hold = solve(prices ,fee , i+1 , 0 , dp);

            return dp[i][canBuy] = Math.max(sell  ,hold);

        }
    }
    public int maxProfit(int[] prices, int fee) {
        int dp[][] = new int [prices.length][2];
        int n = prices.length;

        for(int i = 0 ;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(prices , fee , 0 , 1 , dp);
    }
}