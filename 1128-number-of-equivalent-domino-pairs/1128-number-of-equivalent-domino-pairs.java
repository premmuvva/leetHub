class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Pair<Integer, Integer>, Integer> hm = new HashMap<Pair<Integer, Integer>, Integer>();
        
        Pair<Integer, Integer> pair;
        int count, ans = 0;
        for (int [] i: dominoes) {
            if(i[0] < i[1]) {
                pair = new Pair(i[0], i[1]);
            } else {
                pair = new Pair(i[1], i[0]);
            }
            count = hm.getOrDefault(pair, 0);
            ans += count;
            hm.put(pair, count + 1);
            
        }
        
        return ans;
    }
}