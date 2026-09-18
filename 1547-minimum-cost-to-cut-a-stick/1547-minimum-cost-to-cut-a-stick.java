class Solution {
    public int solve(int[] arr , int left , int right , int dp[][]){
        if(right-left == 1){
            return 0 ;
        }

        if(dp[left][right]!= -1){
            return dp[left][right];
        }

        int ans = Integer.MAX_VALUE;
        for(int idx = left+1 ; idx<right ; idx++){
            int cost = arr[right] - arr[left] + solve(arr , left , idx,dp) + solve(arr ,idx , right,dp);

            ans=  Math.min(ans , cost);
            
        }
        dp[left][right] = ans;
        return dp[left][right];
    }
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int arr[] = new int[m+2];
        arr[0] = 0;
        arr[m+1] = n;

        for(int i =0 ; i<m ; i++){
            arr[i+1] = cuts[i];
        }
        Arrays.sort(arr);

        int dp[][] = new int[m+2][m+2];
        for(int i =0 ;i<m+2;i++){
            Arrays.fill(dp[i] , -1);
        }
        return solve(arr, 0 , m+1 , dp);
    }
}