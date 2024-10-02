class Solution {
    public String minRemoveToMakeValid(String s) {
        int cur = 0;
        StringBuilder sb = new StringBuilder();
        for(char ch: s.toCharArray()) {
            if (ch == '(') {
                cur++;
            } else if (ch == ')') {
                cur --;
                if (cur < 0) {cur = 0; continue;}
            }
            sb.append(ch);
        }
        while(cur > 0) {
            cur--;
            int ind = sb.lastIndexOf("(");
            sb.deleteCharAt(ind);
        }
        
        return sb.toString();
    }
    
}