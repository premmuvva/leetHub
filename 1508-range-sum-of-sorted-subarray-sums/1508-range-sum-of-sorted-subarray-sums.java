class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int mod = 1000000007;
        List<Integer> arr = new ArrayList();
        int sum = 0;
        for (int i = 0; i<n; i++) {
            sum = 0;
            for (int j = i; j<n; j++) {
                sum += nums[j];
                arr.add(sum);
            }
        }
        Collections.sort(arr);
        long ans = 0;
        // System.out.println(arr);
        for (int i = left - 1; i<right; i++) {
            ans+=arr.get(i);
        }
        return (int)(ans % mod);
    }
}