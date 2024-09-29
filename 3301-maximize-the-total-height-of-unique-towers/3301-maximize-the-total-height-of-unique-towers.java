class Solution {
    public long maximumTotalSum(int[] arr1) {
        long ans = 0L;
        Integer[] arr = Arrays.stream(arr1)
                             .boxed()
                             .toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());
        int n = arr.length;
        ans += arr[0];
        int cn = 0, cv = arr[0];
        // HashSet<Integer> hs = new HashSet();
        for (int i = 1; i<n; i++) {
            cv = Math.min(cv -1, arr[i]);
            ans += cv;
            if (cv <= 0) return -1;
            // if (arr[i-1] == arr[i]) {
            //     cv = cv - 1;
            //     if (cv <=0) return -1;
            //     ans += (cv);
            // } else {
            //     cv = cv - 1;
            //     if (cv < arr[i]) {
            //         if (cv <= 0) return -1;
            //         ans += cv;
            //     } else {
            //         ans += arr[i];
            //     }
            //     cn = 0;
            // }
        }
        return ans;
    }
}