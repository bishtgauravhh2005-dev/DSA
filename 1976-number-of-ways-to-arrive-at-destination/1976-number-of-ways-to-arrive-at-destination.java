class Solution {
    class pair{
        int node ;
        long time;

        pair(int node , long time){
            this.node = node ;
            this.time = time ;
        }
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<pair>[] graph = new ArrayList[n];
        for(int i =0 ;i<n ;i++){
            graph[i] = new ArrayList<>();
        }
        for(int [] road : roads){
            int u = road[0];
            int v = road[1];
            int t = road[2];

            graph[u].add(new pair(v,t));
            graph[v].add(new pair(u,t));

        }
        int MOD = 1_000_000_007;
        long time[] = new long [n];
        Arrays.fill(time, Long.MAX_VALUE);
        int[] ways = new int[n];
        ways[0] = 1;
        PriorityQueue <pair> q= new PriorityQueue<>((a,b) -> Long.compare(a.time, b.time));
        q.offer(new pair(0,0));
        while(!q.isEmpty()){
            pair curr = q.poll();
            int u = curr.node;
            long currtime = curr.time;

            if(currtime > time[u]){
                continue;
            }

            for(pair neigh : graph[u]){
                long newtime = neigh.time + currtime;
                int v = neigh.node;

                if(newtime < time[v] ){
                    time[v]  = newtime;

                    ways[v] = ways[u];
                    q.offer(new pair(v , newtime));
                }

                else if(newtime == time[v]){
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }

            }
        }
        return (int) ways[n-1];
    }
}