class Solution {
    // public int solve(int [][] arr , int i , int j , int [][] dp){
    //     if(i>=arr.length || j>= arr[0].length){
    //         return Integer.MAX_VALUE;
    //     }
    //     if(i== arr.length-1 && j == arr[0].length-1){
    //         return Math.max(1 , 1 - arr[i][j]);
    //     }
    //     if(dp[i][j] != -1){
    //         return dp[i][j];
    //     }

    //     int right =  solve(arr , i , j+1 , dp);
    //     int down =  solve(arr , i+1 , j ,dp);
    //     int minhealth = Math.min(right , down );

    //     return  dp[i][j] =Math.max(1 , minhealth - arr[i][j]);
    // }
    // public int calculateMinimumHP(int[][] dungeon) {
    //     int n = dungeon.length;
    //     int m = dungeon[0].length;
    //     int dp[][] = new int[n][m];
    //     for(int i =0 ;i<n ; i++){
    //         Arrays.fill(dp[i] , -1);
    //     }
    //     return solve(dungeon , 0 ,0 ,dp);
    // }
    // Time complexity: O(n×m)
    // Space complexity: O(n×m)


    // tabulation :

    public int calculateMinimumHP(int[][] dungeon) {
 
        int n = dungeon.length;
        int m = dungeon[0].length;
        int [][] dp = new int[n][m];

        for(int r = n-1 ; r>=0 ;r--){
            for(int c = m-1 ;c>=0; c--){

                if(r == n-1 && c == m-1 ){
                    dp[r][c] = Math.max(1,1-dungeon[r][c]);
                }
                else{
                    int right = Integer.MAX_VALUE;
                    int down = Integer.MAX_VALUE;
                    if(r+1 < n){
                        down = dp[r+1][c];
                    }
                    if(c+1 < m){
                        right = dp[r][c+1];
                    }
                    
                    int minhealth = Math.min(right , down);
                    dp[r][c] = Math.max(1 , minhealth - dungeon[r][c]);
                }  
            }
        }
        return dp[0][0];
    }
}