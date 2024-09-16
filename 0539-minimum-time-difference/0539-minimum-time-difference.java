class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size(),i = 0, ans = Integer.MAX_VALUE;
        int arr[] = new int[n];
        for (String str : timePoints) {
            arr[i++] = Integer.parseInt(str.substring(0, 2)) * 60 + Integer.parseInt(str.substring(3,5));
        }
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        int temp, val= 24 * 60;
        for (i = 1; i < n; i++) {
            temp = arr[i] - arr[i-1];
            ans = Math.min(ans, Math.min(val - temp, temp));
        }
        temp = arr[n-1] - arr[0];
        ans = Math.min(ans, Math.min(val - temp, temp));
        return ans;
    }
}