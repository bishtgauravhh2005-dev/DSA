class Solution {
    // public int solve(String s, int i  , int j , int [][] dp){
    //     if( i == j ){
    //         return 1 ;
    //     }

    //     if(i > j ){
    //         return 0;
    //     }

    //     if(dp[i][j] != -1){
    //         return dp[i][j];
    //     }

    //     int ans = 1 + solve(s , i+1 , j , dp);

    //     for(int k = i+1 ; k<= j ;k++){
    //         if(s.charAt(i) == s.charAt(k)){
    //             int cost = solve(s , i+1  , k-1 , dp) + solve(s , k , j , dp);

    //             ans = Math.min(ans , cost);
    //         }
    //     }
    //     return dp[i][j] =  ans ;
    // }
    // public int strangePrinter(String s) {
    //     int dp[][] = new int[s.length()][s.length()];
    //     for(int i=0 ; i<s.length(); i++){
    //         Arrays.fill(dp[i] , -1);
    //     }
    //    return solve(s , 0 , s.length()-1,  dp); 
    // }


    public int strangePrinter(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];

        for(int i = 0 ;i<n ; i++){
            dp[i][i] = 1;
        }


        for(int i = n-1 ; i>=0;i--){
            for(int j = i+1 ; j<n ; j++){
                int ans = 1+ dp[i+1][j];
                for(int k = i+1 ; k<=j ; k++){
                    if(s.charAt(i) == s.charAt(k)){
                        int cost = dp[i+1][k-1] + dp[k][j];
                        ans = Math.min(ans , cost);
                    }   
                }
                dp[i][j] = ans;
            }
        }
        return dp[0][n-1];
    }
}


