class Solution {
    // public int solve(String s , int i  , int j , int [][] dp){
    //     if(i>j) return 0;
    //     if(i == j ) return 1;

    //     if(dp[i][j] != -1){
    //         return dp[i][j];
    //     }

    //     if(s.charAt(i) == s.charAt(j)){
    //         return 2 + solve(s , i+1 , j-1 , dp);
    //     }

    //     return dp[i][j] = Math.max(solve(s ,i , j-1 ,dp) , solve(s,i+1, j, dp)); 
    // }

    // public int longestPalindromeSubseq(String s) {
    //     int n = s.length();
    //     int dp[][] = new int[n][n];

    //     for(int i=0 ;i<n ;i++){
    //         Arrays.fill(dp[i] , -1);
    //     }
    //     return solve(s , 0 , s.length()-1 , dp);
    // }


    // Tabulation :

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];
        for(int i =0 ; i< n ; i++){
            dp[i][i] = 1;
        }

        for(int i = n-1 ;i>=0 ; i--){
            for(int j = i+1; j<n ; j++){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j]= 2 + dp[i+1][j-1];
                }

                else{
                    dp[i][j] = Math.max(dp[i+1][j]  , dp[i][j-1]);
                }
            }
        }

        return dp[0][n-1];
    }
}