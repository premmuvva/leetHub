class MyStack {
    
    Queue<Integer> qu;

    public MyStack() {
        qu = new LinkedList();
    }
    
    public void push(int x) {
        qu.add(x);
    }
    
    public int pop() {
        for (int i = 0; i< qu.size() - 1; i++) {
            qu.add(qu.poll());
        }
        return qu.poll();
    }
    
    public int top() {
        for (int i = 0; i< qu.size() - 1; i++) {
            qu.add(qu.poll());
        }
        int ans = qu.poll();
        qu.add(ans);
        return ans;
    }
    
    public boolean empty() {
        return qu.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */