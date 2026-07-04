class Solution {
    List<List<String>> ans = new ArrayList<>();



    public void adds(char[][] b){
        List<String> s = new ArrayList<>();
        for (int i = 0; i < b.length; i++) {
            s.add(new String(b[i]));
        }
        ans.add(s);
    }

    
    public boolean isSafe(char[][] board, int row, int col) {

    int i = row;
    int j = col;

    while(i >= 0 && j >= 0){
        if(board[i][j] == 'Q')
            return false;

        i--;
        j--;
    }

    i = row;
    j = col;

    while(i >= 0 && j < board.length){
        if(board[i][j] == 'Q')
            return false;

        i--;
        j++;
    }

    i = row;

    while(i >= 0){
        if(board[i][col] == 'Q')
            return false;

        i--;
    }

    return true;
    }

    public void nqueen(char b[][] , int r){
        if(b.length == r){
            adds(b);
            return;
        }
        for(int j=0 ;j<b.length ; j++){
            if(isSafe(b , r, j)){
                b[r][j] = 'Q';
                nqueen(b, r+1);
                b[r][j] = '.';
            }
        }

    }



    public List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];
        for(int i= 0;i<n ;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        nqueen(board , 0);
        return ans;
    }
}
