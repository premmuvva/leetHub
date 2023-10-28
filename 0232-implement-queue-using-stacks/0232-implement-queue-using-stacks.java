class MyQueue {

    Stack<Integer> st, temp;
    public MyQueue() {
        st = new Stack();
        temp = new Stack();
    }
    
    public void push(int x) {
        while(!temp.empty()) 
            st.push(temp.pop());
        st.push(x);
    }
    
    public int pop() {
        while(!st.empty()) 
            temp.push(st.pop());
        return temp.pop();
    }
    
    public int peek() {
        while(!st.empty()) 
            temp.push(st.pop());
        return temp.peek();
    }
    
    public boolean empty() {
        return st.empty() && temp.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */