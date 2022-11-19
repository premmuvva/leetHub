class Solution {
    public int secondHighest(String s) {
        int a = -1, b = -1, t;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                t = c - '0' ;
                if (t > a) {
                    if (t == b) {
                        continue;
                    } else if (t > b) {
                        a = b;
                        b = t;
                    } else {
                        a = t;
                    }
                }
            }
        }
        return a;
    }
}