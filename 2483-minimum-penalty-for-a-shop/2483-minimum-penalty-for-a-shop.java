class Solution {
    public int bestClosingTime(String customers) {
        int ans = 0, pen = 0, fow = 0, min_pen = Integer.MAX_VALUE, max;
        char[] cus = customers.toCharArray();
        for (int i = 0; i < cus.length; i++) {
            if (cus[i] == 'Y') pen++;
        }
        min_pen = pen;
        // System.out.println(pen);
        for (int i = 0; i < cus.length; i++) {
            if (cus[i] == 'Y') pen--;
            else fow++;
            max = fow + pen;
            if (min_pen > max) {
                ans = i + 1;
                min_pen = max;
            } 
            // System.out.println(max);
        }
        return ans;
    }
}