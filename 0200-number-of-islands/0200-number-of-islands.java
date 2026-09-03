class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        int c= 0;
        int [] dx= {0,0,1,-1};
        int [] dy= {1,-1,0,0};
        for(int i=0 ;i<n ;i++){
            for(int j=0 ;j<m ;j++){
                if(grid[i][j] == '1' && !(vis[i][j])){
                    c++;
                    vis[i][j] = true;
                    q.offer(new int[]{i,j});
                    while(!q.isEmpty()){
                        int[] node = q.poll();
                        int x = node[0];
                        int y = node[1];
                        for(int k = 0 ;k<dx.length;k++){
                            int newx = x+dx[k];
                            int newy = y+dy[k];

                            if(newx <0 || newy < 0|| newx>=n || newy >= m || grid[newx][newy] != '1' || vis[newx][newy]){
                                continue;
                            }
                            vis[newx][newy] = true;
                            q.offer(new int[]{newx , newy});
                        }
                    }
                }
            }
        }
    return c;
    }
}