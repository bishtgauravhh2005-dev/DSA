class Solution {
    class Pair{
        int val ;
        int frequency ;
        public Pair(int val , int frequency){
            this.val = val ;
            this.frequency = frequency;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b) -> b.frequency - a.frequency);
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i=0 ;i<nums.length ;i++){
            map.put(nums[i] , map.getOrDefault(nums[i] , 0)+1);
        }
        for(Map.Entry<Integer , Integer> entry : map.entrySet()){
            pq.offer(new Pair(entry.getKey() , entry.getValue()));
        }


        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i] = pq.poll().val;
        }
        
        return ans ;
    }
}