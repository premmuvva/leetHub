class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        for(int i = 0; i<n; i++) {
            dist[i] = (int) Math.ceil(((double)dist[i])/speed[i]);
        }
        Arrays.sort(dist);
        int ans = 0;
        for(int i = 0; i<n; i++, ans++) {
            if(dist[i] <= i) return ans;
        }
        return ans;
    }
}