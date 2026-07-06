class Solution {
    List<List<Character>> ans = new ArrayList<>();

    public boolean isSafe(char b[][] , int r , int c , int dig){
        // horizontal
        for(int i = 0 ;i < 9 ;i++){
            if(b[r][i] == dig){
                return false;
            }
        }
        // vertically
        for(int i = 0 ;i < 9 ;i++){
            if(b[i][c] == dig){
                return false;
            }
        }
        // grid:
        int sr = (r/3) * 3;
        int sc = (c/3) * 3;
        for(int i= sr ; i<= sr+2 ;i++){
            for(int j = sc ; j<=sc+2;j++){
                if(b[i][j] == dig){
                    return false;
                }
            }
        }
        return true;

    }
    public boolean helper(char b [][] , int r , int c){
        if(r == 9 ){
            return true;
        }
        int nextr = r ;
        int nextc = c+1;
        if(nextc >= 9){
            nextr = r+1;
            nextc = 0;
        }
        if(b[r][c] != '.'){
           return helper(b , nextr ,nextc);
        }

        for(char i='1';i<='9' ;i++){
            if(isSafe(b , r , c , i)){
                b[r][c] =(char)i;
                if(helper(b , nextr, nextc)){
                    return true;
                }
                b[r][c] = '.';
            }

        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        helper(board , 0 , 0);
    }
}