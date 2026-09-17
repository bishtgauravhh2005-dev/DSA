class Solution {
    public int solve(int coins[] , int amount , int i , int dp [][]){
        if(amount < 0 ){
            return Integer.MAX_VALUE;
        }
        if(i==coins.length){
            return Integer.MAX_VALUE;
        }
        if(dp[i][amount] != -1){
            return dp[i][amount];
        }

        if(amount ==0){
            return 0;
        }

        int ans1 =   solve(coins , amount - coins[i] , i , dp);
        if(ans1 != Integer.MAX_VALUE){
            ans1 = 1+ans1;
        }
        int ans2 = solve(coins , amount , i+1 , dp);

        dp[i][amount] = Math.min(ans1, ans2);
        return dp[i][amount];
        
    }
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length][amount+1];

        for(int i=0 ;i<coins.length ;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans = solve(coins , amount , 0 , dp);
        if(ans == Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
}