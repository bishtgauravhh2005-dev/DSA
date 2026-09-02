class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int dist[][] = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int i =0 ;i< n ;i++){
            for(int j =0 ;j<m ;j++){
                if(mat[i][j] == 0 ){
                    q.offer(new int[] {i,j});
                }
                else{
                    dist[i][j] = -1;
                }
            }
        }


        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            for(int d=0;d<dx.length ;d++){
                int newx = x + dx[d];
                int newy = y + dy[d];

                if(newx<0 || newy < 0 || newx >= n || newy >=m || dist[newx][newy] != -1){
                    continue;
                }

                dist[newx][newy] = dist[x][y] +1;
                q.offer(new int[] {newx ,newy});
            }
        }
        return dist;
    }
}