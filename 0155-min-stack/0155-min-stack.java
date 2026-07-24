class MinStack {
    class pair {
        int val1;
        int val2;

        pair(int val1, int val2){
            this.val1= val1;
            this.val2 = val2;
        }
    }

    Stack<pair> s = new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int value) {
        if(s.isEmpty()){
            s.push(new pair(value , value));
        }
        else{
            int minVal = Math.min(value , s.peek().val2);
            s.push(new pair(value , minVal));
        }
    }
    
    public void pop() {
        s.pop();
    }
    
    public int top() {
        return s.peek().val1;
    }
    
    public int getMin() {
        return s.peek().val2;
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