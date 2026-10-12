class Solution {
    public int solve(int k , int[] prices , int i , int canBuy , int t , int dp[][][]){
        if(i == prices.length || t==k){
            return 0;
        }
        if(dp[i][canBuy][t] != -1){
            return dp[i][canBuy][t];
        }

        if(canBuy == 1){
            int buy = -prices[i] + solve(k , prices , i+1 , 0 , t, dp);
            int skip = solve(k , prices , i+1 , 1 , t , dp);

            return dp[i][canBuy][t] = Math.max(buy , skip);
        }
        else{
            int sell = prices[i] + solve(k , prices, i+1 , 1 , t+1 , dp);
            int hold = solve(k , prices , i+1 , 0 , t , dp);

            return dp[i][canBuy][t] = Math.max(sell , hold);
        }

        
    }
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n][2][k];

        for(int[][] layer : dp){
            for(int [] x : layer){
                Arrays.fill(x , -1);
            }
        }
        return solve(k, prices , 0 , 1 , 0 , dp);
    }
}