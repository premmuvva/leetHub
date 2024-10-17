class Solution {
    public int maximumSwap(int num) {
        String str = String.valueOf(num);
        int st = 0, n = str.length();
        for (int i = 0; i < n-1; i++) {
            char best = str.charAt(i);
            st = i;
            for (int j = i+1; j < n; j++) {
                if (best <= str.charAt(j)) {
                    best = str.charAt(j);
                    st = j;
                }
            }
            if (best != str.charAt(i)) {
                return Integer.parseInt(str.substring(0, i) + best + str.substring(i+1, st) + str.charAt(i) + str.substring(st+1));
            }
        }
        return num;
    }
}