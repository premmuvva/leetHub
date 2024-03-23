class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int offset = arr.length / 20;
        double ans = 0;
        for(int i = arr.length - offset - 1; i >= offset; i--) {
            ans += arr[i];
        }
        return ans / (arr.length - offset - offset);
    }
}