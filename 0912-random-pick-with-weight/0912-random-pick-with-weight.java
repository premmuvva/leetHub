import java.util.Random;

class Solution {
    TreeMap<Integer, Integer> tm;
    int max, n;
    public Solution(int[] w) {
        tm = new TreeMap();
        n = w.length;
        int val = 0;
        for(int i = 0; i<n; i++) {
            val += w[i];
            tm.put(val, i);
        }
        max = val;
    }
    
    public int pickIndex() {
        double tar = Math.random() * (max);
        Map.Entry<Integer, Integer> en = tm.ceilingEntry((int)Math.ceil(tar));
        return en.getValue();
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */