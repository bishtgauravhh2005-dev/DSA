class Solution {
    public boolean traversalGrid(char[][] board , int sr , int er , int sc , int ec){
        HashSet<Character> s = new HashSet<>();
        for(int i = sr ; i<=er ; i++){
            for(int j = sc ; j<=ec ; j++){
                if(board[i][j] == '.') continue;
                if(s.contains(board[i][j])) return false;
                s.add(board[i][j]);
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        for(int r= 0 ; r< 9 ; r++){
            HashSet<Character> set = new HashSet<>();
            for(int c = 0 ;c<9 ; c++){
                if(board[r][c] == '.') continue;
                if(set.contains(board[r][c])){
                    return false ;
                }
                set.add(board[r][c]);
            }
        }


        for(int c= 0 ; c< 9 ; c++){
            HashSet<Character> set = new HashSet<>();
            for(int r = 0 ;r<9 ; r++){
                if(board[r][c] == '.') continue;
                if(set.contains(board[r][c])){
                    return false ;
                }
                set.add(board[r][c]);
            }
        }


        for(int sr = 0 ; sr< 9 ; sr+=3){
            int er = sr+2;
            for(int sc = 0 ; sc< 9 ; sc+=3){
                int ec = sc+2;
                if(!traversalGrid(board ,sr , er , sc , ec)) return false;
            }
        }
    return true;
    }
}