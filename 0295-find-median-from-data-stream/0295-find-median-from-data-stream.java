class MedianFinder {
    public PriorityQueue<Integer> left;
    public PriorityQueue<Integer> right; 
    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(right.isEmpty() || num >= right.peek()){
            right.offer(num);
        }
        else{
            left.offer(num);
        }
        

        // balance
        if(right.size() > left.size()+1){
            left.offer(right.poll());
        }
        if(left.size() > right.size()){
            right.offer(left.poll());
        }

    }
    
    public double findMedian() {
                if (left.isEmpty() && right.isEmpty()) {
            return 0.0;
        }
        if(right.size() == left.size()){
            return (right.peek()+left.peek())/2.0;
        }
        else{
            return right.peek();          
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */