class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int x  ;
    public KthLargest(int k, int[] nums) {
        x = k;
        minHeap = new PriorityQueue<>();
        for(int num : nums){
            add(num);
        }
        
    }
    
    public int add(int val) {
        minHeap.offer(val);
        if(minHeap.size() > x){
            minHeap.poll();
        }
        

        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */