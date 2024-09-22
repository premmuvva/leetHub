class Solution {
    public long minNumberOfSeconds(int h, int[] ti) {
        // Arrays.sort(ti);
        
        // int n = ti.length, ans = 0;
        // if (n == 1) return (h * (h + 1))/2;
        
        // int i, jj;
        // for (int ii = 0; h > 0; ii++) {
        //     if (h == 0) break;
        //     // if (i == n-1) i = 0;
        //     i = ii % n;
        //     jj = (ii +1) % n;
        //     ans += (++ct[i]) * ti[i];
        //     h--;
        //     while((ct[i] + 1) * ti[i] <= (ct[jj] + 1) * ti[jj]) {
        //         if (h == 0) break;;
        //         h--;
        //         ans += (++ct[i]) * ti[i];
        //     }
        //     System.out.printf("%d %d\n", ans, h);
        // }
        int n = ti.length;
        long[] ct = new long[n];
        PriorityQueue<long[]> pq = new PriorityQueue<long[]>((a, b) -> {
            if (a[0] != b[0]) return Long.compare(a[0],b[0]);
            return Long.compare(a[2] * a[1], b[2] * b[1]);
        });
        for (int i =0; i<n; i++) pq.add(new long[]{ti[i], ti[i], 2});
        long ii[], jj[];
        long ans = 0;
        while(h > 0) {
            ii = pq.poll();
            // System.out.print(Arrays.toString(ii));
            // ii[1]]++;
            long temp = ii[0] + ii[1] * ii[2];
            ans = Math.max(ii[0], ans);
            pq.add(new long[]{temp, ii[1], ii[2] + 1});
            h--;
            // print(pq);
        }
        // Arrays.sort(ct);
        // ii = pq.poll();

        return ans;
    }

    void print(PriorityQueue<int[]> pq) {
        List<int[]> tempList = new ArrayList<>(pq);

        for (int i = 0; i < tempList.size(); i++) {
            System.out.print("[" + tempList.get(i)[0] + ", " + tempList.get(i)[1] + ", " + tempList.get(i)[2] + "]");
            if (i < tempList.size() - 1) {
                System.out.print(", "); // Add a comma for all but the last element
            }
        }
        System.out.println("]");
    }
}