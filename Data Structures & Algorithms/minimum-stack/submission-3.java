class MinStack {
    Deque<Integer> stack;
    public MinStack() {
        stack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        int min = Integer.MAX_VALUE;
        for(Integer num : stack) {
            min = Math.min(min, num);
        }
        return min;
    }
}
