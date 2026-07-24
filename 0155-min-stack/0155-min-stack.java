class MinStack {
    // class pair {
    //     int val1;
    //     int val2;

    //     pair(int val1, int val2){
    //         this.val1= val1;
    //         this.val2 = val2;
    //     }
    // }

    // Stack<pair> s = new Stack<>();
    // public MinStack() {
        
    // }
    
    // public void push(int value) {
    //     if(s.isEmpty()){
    //         s.push(new pair(value , value));
    //     }
    //     else{
    //         int minVal = Math.min(value , s.peek().val2);
    //         s.push(new pair(value , minVal));
    //     }
    // }
    
    // public void pop() {
    //     s.pop();
    // }
    
    // public int top() {
    //     return s.peek().val1;
    // }
    
    // public int getMin() {
    //     return s.peek().val2;
    // }
    // class pair {
    //     int val1;
    //     int val2;

    //     pair(int val1, int val2){
    //         this.val1= val1;
    //         this.val2 = val2;
    //     }
    // }

    Stack<Long> s = new Stack<>();
    long minVal;
    public MinStack() {
        
    }
    
    public void push(int value) {
       if(s.isEmpty()){
            s.push((long)value);
            minVal = value;
       }
       else if(minVal > value){
            s.push(2L * value - minVal);
            minVal = value;
       }
       else{
            s.push((long)value);
       }
    }
    
    public void pop() {
       if(s.peek() < minVal){
            minVal = 2L*minVal - s.peek();
       }

        s.pop();
    }
    
    public int top() {
        if(s.peek() < minVal){
            return (int)minVal;
        }
        else{
            return s.peek().intValue();
        }
    }
    
    public int getMin() {
        return (int)minVal;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */