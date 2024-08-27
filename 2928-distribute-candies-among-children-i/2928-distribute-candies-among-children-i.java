class Solution {
    public int distributeCandies(int n, int limit) {
        // limit = Math.min(n/3, limit);
        int t = 0, d = 0, s = 0;
        for(int i = limit; i >= 0; i--) {
            for(int j = limit; j>=0; j--) {
                int k = n - i - j;
                if(k < 0 || k > limit) continue;
                if(i == j && j == k) {
                    t++;
                } else if (i == j || j == k || k == i) {
                    d++;
                } else {
                    s++;
                }
                
                // System.out.printf("%d, %d, %d - \n", i, j, k);
            }
        }
        // System.out.printf("%d, %d, %d\n", s, d, t);
        return s+(d)+(t);
    }
}