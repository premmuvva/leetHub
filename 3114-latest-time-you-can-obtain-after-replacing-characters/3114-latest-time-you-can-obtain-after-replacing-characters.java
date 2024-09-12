class Solution {
    public String findLatestTime(String s) {
        int a[], b[], c[], d[];
        if (s.charAt(0) == '?') {
            a = new int[]{0, 1};
        } else {
            a = new int[]{s.charAt(0) -'0'};
        }
        if (s.charAt(1) == '?') {
            b = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        } else {
            b = new int[]{s.charAt(1) -'0'};
        }
        if (s.charAt(3) == '?') {
            c = new int[]{0, 1, 2, 3, 4, 5};
        } else {
            c = new int[]{s.charAt(3) -'0'};
        }
        if (s.charAt(4) == '?') {
            d = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        } else {
            d = new int[]{s.charAt(4) -'0'};
        }
        int ans = Integer.MAX_VALUE;
        int aa = 0, bb = 0, cc = 0, dd = 0;
        for (int i: a) {
            for (int j: b) {
                for (int k: c) {
                    for (int l: d) {
                        int temp = i*10 + j;
                        if (temp >= 12) continue;
                        temp = temp * 60 + k*10 + l;
                        if (Math.abs(temp - 12*60) < ans) {
                            ans = Math.abs(temp - 12*60);
                            aa = i; 
                            bb = j;
                            cc = k;
                            dd = l;
                        }
                    }
                }
            }
        }
        return String.valueOf(aa) + bb + ":" + String.valueOf(cc) + dd;
    }
}