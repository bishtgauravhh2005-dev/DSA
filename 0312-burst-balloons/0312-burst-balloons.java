class Solution {
    public int solve(int [] arr , int i , int j , int[][] dp){
        if(i+1 >= j){
            return 0 ; // as there is no more ballon is present 
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int ans = 0;
        for(int k = i+1 ; k< j ;k++){
            int cost = arr[i] * arr[k] * arr[j] + solve(arr , i , k , dp) + solve(arr , k , j , dp);
            ans = Math.max(ans ,cost);
        }

        return dp[i][j] = ans ;
    }
    public int maxCoins(int[] nums) {
        int n = nums.length ;

        int arr[] = new int[n+2];
        arr[0] = 1;
        arr[n+1]=1;

        int dp[][] = new int [n+2][n+2];

        for(int i=0 ;i< n+2 ; i++){
            Arrays.fill(dp[i] , -1);
        }

        for(int i =0 ; i < n ; i++){
            arr[i+1] = nums[i];
        }

        return solve(arr , 0 , n+1 , dp);
    }
}