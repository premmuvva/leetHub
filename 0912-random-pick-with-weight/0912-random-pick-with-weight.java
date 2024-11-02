import java.util.Random;

class Solution {
    TreeMap<Integer, Integer> tm;
    int max, n;
    // Random rand;
    public Solution(int[] w) {
        // rand = new Random();
        tm = new TreeMap();
        n = w.length;
        int val = 0;
        for(int i = 0; i<n; i++) {
            val += w[i];
            tm.put(val, i);
        }
        max = val;
        System.out.println(tm);
    }
    
    public int pickIndex() {
        double tar = Math.random() * (max);
        // int st = 1, en = w.length-1, mid = st;
        // while(st < en) {
        //     mid = st + (en - st)/2;
        //     if (w[mid] == tar) {
        //         return mid;
        //     } else if (w[mid] < tar) {
        //         st = mid + 1;
        //     } else {
        //         en = mid - 1;
        //     }
        // }
        // return st - 1;
        Map.Entry<Integer, Integer> en = tm.ceilingEntry((int)Math.ceil(tar));
        return en.getValue();
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */