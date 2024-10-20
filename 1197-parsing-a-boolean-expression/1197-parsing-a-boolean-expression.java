class Solution {
    public boolean parseBoolExpr(String expression) {
        int n = expression.length();
        Stack<Character> st = new Stack();
        boolean tru = false, fal = false;
        char temp;
        for (int i = 0; i<n; i++) {
            char ch = expression.charAt(i);
            tru = false;
            fal = false;
            if (ch == ')') {
                while(st.peek() != '(') {
                    temp = st.pop();
                    if (temp == 't') tru = true;
                    else if (temp == 'f') fal = true;
                }
                st.pop();
                temp = st.pop();
                if (temp == '|') {
                    st.push(tru ? 't' : 'f');
                } else if (temp == '!') {
                    st.push(tru ? 'f' : 't');
                } else {
                    st.push(fal ? 'f' : 't');
                }
            } else {
                st.push(ch);
            }
        }
        return st.pop() == 't';
    }
}