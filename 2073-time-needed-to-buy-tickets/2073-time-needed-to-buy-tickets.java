class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        // Queue<Integer> q = new LinkedList<>();
        // for(int i =0 ;i < tickets.length ; i++){
        //     q.offer(i);
        // }
        // int timeNeeded = 0;
        // while(!q.isEmpty()){
        //     timeNeeded++;
        //     int f = q.peek();
        //     q.poll();
        //     tickets[f]--;

        //     if(k == f && tickets[f] == 0) return timeNeeded;
        //     if(tickets[f] != 0) q.offer(f);

        // }
        // return timeNeeded;


        int time = 0 ;
        for(int i =0 ;i<tickets.length; i++){
            if(k>=i) {
                time += Math.min(tickets[k] , tickets[i]);
            }
            else{
                time+= Math.min(tickets[k] - 1 , tickets[i]);
            }

        }
        return time;
    }
}