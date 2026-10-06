class Solution {
    // public int solve(int[][] grid , int r1 , int c1 , int r2 , int[][][] dp){
    //     int c2 = r1 + c1 - r2;
    //     if(r1 >=grid.length || r2 >= grid.length || c1 >= grid[0].length || c2 >= grid[0].length 
    //     || grid[r1][c1] == -1 || grid[r2][c2] == -1){
    //         return Integer.MIN_VALUE;
    //     }
    //     if(r1==grid.length-1 && c1 == grid.length-1){
    //         return grid[r1][c1];
    //     }

    //     if(dp[r1][c1][r2] != -1){
    //         return dp[r1][c1][r2];
    //     }
    //     int cherries = 0 ;
    //     if(r1 == r2 && c1 == c2){
    //         cherries+= grid[r1][c1];
    //     }
    //     else{
    //         cherries += grid[r1][c1] + grid[r2][c2];
    //     }

    //     int ans1 = solve(grid ,r1 +1 , c1 , r2 , dp);
    //     int ans2 = solve(grid ,r1 , c1+1 , r2 +1, dp);
    //     int ans3 = solve(grid ,r1 , c1+1 , r2, dp);
    //     int ans4 = solve(grid ,r1 +1 , c1 , r2+1, dp);

    //     int best = Math.max(Math.max(ans1, ans2),Math.max(ans3, ans4));

    //     if (best == Integer.MIN_VALUE) {
    //         return dp[r1][c1][r2] = best;
    //     }

    // return dp[r1][c1][r2] = cherries + best;

    // }
    // public int cherryPickup(int[][] grid) {
    //     // Rather than returning a person back for different route , we will
    //     // send 2 person and 1 person for going and another for reverse back .
    //     int n = grid.length;
    //     int dp[][][] = new int[n][n][n];
    //     for(int i =0 ;i < n ; i++){
    //         for(int j=0 ; j< n ;j++){
    //             Arrays.fill(dp[i][j] , -1);
    //         }
    //     }
    //     return Math.max(solve(grid , 0 , 0 , 0 , dp) , 0);
    // }


    // tabulation :
    public int cherryPickup(int[][] grid){
        int n = grid.length;
        int dp[][][] = new int[n][n][n];

        for(int i =0 ;i <n ;i++){
            for(int j =0 ; j<n ;j++){
                Arrays.fill(dp[i][j] , Integer.MIN_VALUE);
            }
        }

        dp[0][0][0] = grid[0][0];
        for(int r1 =0; r1<n ;r1++){
            for(int c1=0 ;c1<n ; c1++){
                for(int r2= 0 ; r2<n ; r2++){
                    int c2 = r1 + c1 -r2;

                    if(r1 == 0 && c1 == 0 && r2 == 0){
                        continue;
                    }
                    if(c2<0 || c2>=n){
                        continue;
                    }

                    if(grid[r1][c1] == -1 || grid[r2][c2] == -1){
                        continue;
                    }

                    int best = Integer.MIN_VALUE;

                    if(r1> 0 && r2>0){
                        best = Math.max(best , dp[r1-1][c1][r2-1]);
                    }

                    if(r1>0){
                        best =Math.max(best , dp[r1-1][c1][r2]);
                    }

                    if(r2>0 && c1>0) {
                        best = Math.max(best , dp[r1][c1-1][r2-1]);
                    }

                    if(c1 > 0){
                        best = Math.max(best , dp[r1][c1-1][r2]);
                    }


                    if(best == Integer.MIN_VALUE){
                        continue;
                    }

                    int cherries = 0;

                    if(r1==r2 && c1 == c2){
                        cherries = grid[r1][c1];
                    }
                    else{
                        cherries = grid[r1][c1] + grid[r2][c2];
                    }
                    

                    dp[r1][c1][r2] = cherries + best;
                }
            }
        }

        return Math.max(0 , dp[n-1][n-1][n-1]);
    }

}