class Solution {
    public int solve(String s1 , String s2 , int l1 , int l2 , int[][] dp){
        if(l1 == s1.length() || l2 == s2.length()){
            return 0 ;
        }
        if(s1.charAt(l1) == s2.charAt(l2)){
            return 1 + solve(s1 , s2 , l1+1 , l2+1 ,dp);
        }
        if(dp[l1][l2] != -1){
            return dp[l1][l2];
        }

        int c1 = solve(s1 , s2 , l1+1 , l2,dp) ;
        int c2 = solve(s1 , s2 , l1, l2+1 ,dp);

        return dp[l1][l2] = Math.max(c1 , c2);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int dp[][] = new int[n1+1][n2+1];

        for(int i=0 ;i<n1 ; i++){
            Arrays.fill(dp[i] , -1);
        }
        return solve(text1 , text2 , 0 , 0 , dp);
    }
}