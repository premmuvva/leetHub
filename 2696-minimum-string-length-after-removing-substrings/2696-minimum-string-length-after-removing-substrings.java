class Solution {
    public int minLength(String s) {
        Stack<Character> st = new Stack();
        for (char ch: s.toCharArray()) {
            if (ch == 'D' && st.size() > 0 && st.peek() == 'C') {
                st.pop();
            } else if (ch == 'B' && st.size() > 0 && st.peek() == 'A') {
                st.pop();
            } else {
                st.push(ch);
            }
        }
        return st.size();
    }
}