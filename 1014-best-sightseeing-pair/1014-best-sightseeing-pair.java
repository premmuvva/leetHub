class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        // int i = 1, n = values.length, a = Integer.MIN_VALUE, b = Integer.MIN_VALUE;
        // int arr[] = new int[n];
        // arr[0] = values[0];
        // for(i=1; i< n; i++) {
        //      arr[i] = Math.max(arr[i-1], i + values[i]);
        // }
        // values[n-1] = values[n-1] - n + 1;
        // for(i=n-2; i>=0; i--) {
        //      values[i] = Math.max(values[i+1], values[i] - i);
        // }
        // // System.out.println(Arrays.toString(arr));
        // // System.out.println(Arrays.toString(values));
        // for (i =0; i<n-1; i++) {
        //     a = Math.max(a, arr[i] + values[i+1]);
        // }
        // return a;
        
        int n = values.length;
        int ans = 0, ci = values[0];
        
        for (int i = 1; i< n; i++) {
            ans = Math.max(ans, values[i] - i + ci);
            ci = Math.max(ci, i+values[i]);
        }
        return ans;
    }
}