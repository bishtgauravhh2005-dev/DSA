class Solution {

    // Recursive Approach.
    // public int numTrees(int n) {
    //     if(n<=1){
    //         return 1;
    //     }

    //     int ans =0 ;
    //     for(int i = 1 ;i<=n ;i++){
    //         ans += numTrees(i-1) * numTrees(n-i);
    //     }

    // return ans;
    // }


    // Memoization Approach

    // public int solve(int n , int dp[]) {
    //     if(n<=1){
    //         return 1;
    //     }

    //     if(dp[n] != -1){
    //         return dp[n];
    //     }

    //     int ans =0 ;
    //     for(int i = 1 ;i<=n ;i++){
    //         ans += solve(i-1 , dp) * solve(n-i , dp);
    //     }

    // return dp[n] = ans;
    // }
    // public int numTrees(int n){
    //     int dp[] = new int[n+1];
    //     Arrays.fill(dp , -1);

    //     return solve(n , dp);
    // }


    // Tabulation Approach.

    public int numTrees(int n){
        int[] dp = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i=2 ; i<=n ;i++){
            for(int j=1 ;j<=i; j++){
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
    return dp[n];
    }
}