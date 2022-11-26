class Solution {
    public int bestClosingTime(String s) {
        int ans = 0, pen = 0, fow = 0, min_pen = Integer.MAX_VALUE, max;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'Y') pen++;
        }
        min_pen = pen;
        // System.out.println(pen);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'Y') pen--;
            else fow++;
            if (min_pen > fow + pen) {
                ans = i + 1;
                min_pen = fow + pen;
            } 
            // System.out.println(max);
        }
        return ans;
    }
}