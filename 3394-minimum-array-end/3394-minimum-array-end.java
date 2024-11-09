class Solution {
    public long minEnd(int nn, int xx) {
        // int bits = count(x);
        long n = nn, x = xx;
        int[] nbits = new int[64], xbits = new int[64];
        n--;
        for (int i =0 ; i< 40; i++) {
            nbits[i] = (int)((n>>i)&1);
            xbits[i] = (int)((x>>i)&1);
        }
        // System.out.println(Arrays.toString(nbits));
        // System.out.println(Arrays.toString(xbits));
        int cx = 0, cn = 0;
        while(cx < 64) {
            while(xbits[cx] != 0 && cx < 64) ++cx;
            xbits[cx++] = nbits[cn++];
        }

        // System.out.println(Arrays.toString(nbits));
        // System.out.println(Arrays.toString(xbits));
        long ans = 0L;
        for(int i = 0; i<64; i++) {
            ans |= ((long)xbits[i]<<i);
        }
        return ans;

    }

    int count(int x) {
        int ans = 0;
        int i = 0;
        while(i < 31) {
            ans += x>>i++;
        }
        return ans;
    }
}