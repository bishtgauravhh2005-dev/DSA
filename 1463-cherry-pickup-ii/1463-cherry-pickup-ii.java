class Solution {
    public int solve(int[][] grid , int r ,int  c1 ,int c2 , int [][][] dp){
        int n = grid.length ;
        int m = grid[0].length;
        if(c1 >= m || c1 < 0 || c2 >= m || c2<0){
            return Integer.MIN_VALUE;
        }
        if(r== n-1){
            if(c1 != c2){
                return grid[r][c1] + grid[r][c2];
            }

            return grid[r][c1];
        }
        if(dp[r][c1][c2] != -1){
            return dp[r][c1][c2];
        }

        int cherries = grid[r][c1];

        if(c1 != c2){
            cherries += grid[r][c2];
        }
        int maxcherry = Integer.MIN_VALUE;
        for(int i = -1 ; i<=1 ; i++){
            for(int j = -1 ; j <= 1 ; j++){
                int x = solve(grid , r+1 , c1+i , c2+j , dp); 
                maxcherry = Math.max(maxcherry , x);
            }
        }

        return dp[r][c1][c2] = cherries + maxcherry;
    }
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [][][] dp = new int[n][m][m];
        for(int [][] layer: dp){
            for(int [] x : layer){
                Arrays.fill(x , -1);
            }
        } 
        return solve(grid , 0 , 0 , m-1 , dp);
    }
}