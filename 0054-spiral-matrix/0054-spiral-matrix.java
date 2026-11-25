class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        ArrayList<Integer> ans = new ArrayList<>();
        int sr = 0 ;
        int sc = 0 ;
        int er = n-1;
        int ec = m-1;

        while(sr<=er && sc<=ec ){
            for(int i = sc ; i <= ec; i++){
                ans.add(matrix[sr][i]);
            }
            sr++;

            for(int i = sr ; i<= er ; i++){
                ans.add(matrix[i][ec]);
            }
            ec--;
            if(er>=sr){
                for(int i = ec ; i>=sc ; i--){
                    ans.add(matrix[er][i]);
                }
                er--;
            }

            if(ec >= sc){
                for(int i =er ; i>= sr ; i--){
                ans.add(matrix[i][sc]);
                }
                sc++;
            }
           
        }
    return ans ;
    }
}