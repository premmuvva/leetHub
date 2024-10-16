class Solution {
    
    public String longestDiverseString(int a, int b, int c) {
        return rec(a, b, c, new StringBuilder()).toString();
    }

    StringBuilder rec(int a, int b, int c, StringBuilder cur) {
        int ca = 0, cb = 0, cc = 0, i = a + b + c;
        while(i-- > 0) {
            if ((a >= b && a >= c && ca != 2 ) || (a > 0 && (cb == 2 || cc == 2))) {
                cur.append('a');
                ca++;
                a--;
                cb = 0;
                cc = 0;
            } else if ((a <= b && b >= c && cb != 2 ) || (b > 0 && (ca == 2 || cc == 2))) {
                cur.append('b');
                cb++;
                b--;
                ca = 0;
                cc = 0;
            } else if ((a <= c && c >= b && cc != 2 ) || (c > 0 && (ca == 2 || cb == 2))) {
                cur.append('c');
                cc++;
                c--;
                ca = 0;
                cb = 0;
            }
        }
        return cur;
    }
}