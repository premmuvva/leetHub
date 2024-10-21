class Solution {
    public long[] maximumCoins(int[] heroes, int[] monsters, int[] coins) {
        int n = coins.length, hl = heroes.length;
        Pair<Integer, Integer>[] mon =  (Pair<Integer, Integer>[])new Pair[n];
        for (int i = 0; i<n; i++) {
            mon[i] = new Pair(monsters[i], coins[i]);
        }
        Arrays.sort(mon, (a, b) -> a.getKey() - b.getKey());
        Pair<Integer, Integer>[] hero =  (Pair<Integer, Integer>[])new Pair[hl];
        for (int i = 0; i<hl; i++) {
            hero[i] = new Pair(heroes[i], i);
        }
        Arrays.sort(hero, (a, b) -> a.getKey() - b.getKey());
        long[] ans = new long[hl];
        // Arrays.sort(heroes);
        int cv = 0, mc = 0;
        while(mc < n && hero[0].getKey() >= mon[mc].getKey()) {
            ans[hero[0].getValue()] += mon[mc++].getValue();
        }
        for (int i = 1; i<hl; i++) {
            ans[hero[i].getValue()] += ans[hero[i-1].getValue()];
            while(mc < n && hero[i].getKey() >= mon[mc].getKey()) {
                ans[hero[i].getValue()] += mon[mc++].getValue();
            }
        }
         
        return ans;
    }
}