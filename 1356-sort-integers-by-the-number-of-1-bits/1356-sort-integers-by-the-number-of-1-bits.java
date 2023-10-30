class Solution {
    public int[] sortByBits(int[] arr) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> (a[0]-b[0] == 0) ? (a[1]-b[1]) : a[0]-b[0]);
        int n = arr.length, i;
        for(int ii: arr) 
            pq.add(new int[]{count(ii), ii});
        i = 0;
        while(pq.size() > 0) {
            arr[i++] = pq.poll()[1];
        }
        return arr;
    }
    
    private int count(int i) {
        int ans = 0;
        while(i>0) {
            if((i&1) == 1)
                ans++;
            i=i>>1;
        }
        return ans;
    }
}