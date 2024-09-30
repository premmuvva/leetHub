class CustomStack {
    
    int ps[] = new int[1000], arr[], cur;
    // Stack<Integer> st;
    public CustomStack(int maxSize) {
        arr = new int[maxSize];
        cur = 0;
    }
    
    public void push(int x) {
        if (cur == arr.length) return;
        arr[cur++] = x;
    }
    
    public int pop() {
        if (cur == 0) return -1;
        cur--;
        int ans = ps[cur] + arr[cur];
        if (cur > 0) ps[cur-1] += ps[cur];
        ps[cur] = 0;
        return ans;
    }
    
    public void increment(int k, int val) {
        // int curr = Math.max(0, cur -1);
        if (cur == 0) return;
        ps[Math.min(k-1, cur-1)] += val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */