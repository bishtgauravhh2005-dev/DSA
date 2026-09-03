class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int color[] = new int [n];
        Arrays.fill(color, -1);
        Queue<Integer> q = new LinkedList<>();

        for(int i=0 ;i<n ;i++){
            if(color[i] != -1){
                continue;
            }
            color[i] = 0;
            q.offer(i);

            while(!q.isEmpty()){
                int curr = q.poll();
                for(int neigh : graph[curr]){
                    if(color[neigh] == -1){
                        color[neigh] = 1 - color[curr];
                        q.offer(neigh);
                    }
                    else if(color[neigh] == color[curr]){
                        return false;
                    }
                }
            }
        }
    return true;
    }
}