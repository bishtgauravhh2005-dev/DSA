class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int minDist[] = new int[n];
        boolean vis[] = new boolean[n];

        Arrays.fill(minDist , Integer.MAX_VALUE);
        minDist[0] = 0;

        int totalCost = 0;
        for(int count = 0 ;count < n ;count++){
            int u = -1;

            for(int i=0 ;i< n ;i++){
                if(!vis[i] && (u == -1 || minDist[i] < minDist[u])){
                    u=i;
                }
            }
        
        vis[u] = true;
        totalCost += minDist[u];
        for(int v=0;v<n ;v++){
            if(!vis[v]){
                int dist = Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1]);
                minDist[v] = Math.min(dist , minDist[v]);
            }
        }
        }
    return totalCost;
    }
}