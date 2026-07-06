class Solution {
    public boolean isValid(int [][] grid , int r , int c , int expected){
        if(r<0 || c<0 || c>=grid.length || r>=grid.length || grid[r][c] != expected){
            return false;
        }
        if(expected == grid.length * grid.length - 1){
            return true;
        }
        // possible move :
        boolean ans1 = isValid(grid , r-2 , c+1 , expected+1);
        boolean ans2 = isValid(grid , r-1 , c+2 , expected+1);
        boolean ans3 = isValid(grid , r+1 , c+2 , expected+1);
        boolean ans4 = isValid(grid , r+2 , c+1 , expected+1);
        boolean ans5 = isValid(grid , r+2 , c-1 , expected+1);
        boolean ans6 = isValid(grid , r+1 , c-2 , expected+1);
        boolean ans7 = isValid(grid , r-1 , c-2 , expected+1);
        boolean ans8 = isValid(grid , r-2 , c-1 , expected+1); 
        

        return ans1 || ans2 || ans3 || ans4 || ans5 || ans6 || ans7 || ans8 ;
    }
    public boolean checkValidGrid(int[][] grid) {
        return isValid(grid , 0 , 0 , 0 );
    }
}