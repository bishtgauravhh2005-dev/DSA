class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        // int timeNeeded = 0;
        // for(int i=0;i<tickets.length ;i++){
        //     if(i<=k){
        //         timeNeeded += Math.min(tickets[i] , tickets[k]);
        //     }
        //     else{
        //         timeNeeded += Math.min(tickets[k]-1 , tickets[i]);
        //     }
        // }
        // return timeNeeded;

        Queue<Integer> q = new LinkedList<>();
        for(int i =0 ;i < tickets.length ; i++){
            q.offer(i);
        }
        int timeNeeded = 0;
        while(!q.isEmpty()){
            timeNeeded++;
            int f = q.peek();
            q.poll();
            tickets[f]--;

            if(k == f && tickets[f] == 0) return timeNeeded;
            if(tickets[f] != 0) q.offer(f);
        }
        return timeNeeded;
    }
}