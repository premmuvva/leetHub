class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        HashMap<Integer, Long> hm = new HashMap();
        long ans = 1, sum;
        Arrays.sort(arr);
        int n = arr.length, temp;
        hm.put(arr[0], ans);
        for(int i = 1; i < n; i++) {
            sum = 1;
            for (int j = 0; j<i; j++) {
                temp = arr[i]/arr[j];
                if (arr[i] % arr[j] == 0 && hm.containsKey(temp)) {
                    sum += hm.get(temp) * hm.get(arr[j]);
                }
            }
            ans += sum;
            hm.put(arr[i], sum);
            
            // hm.merge(arr[j], 1, Integer::sum);
            // hm.merge(arr[j] * arr[i], 1, Integer::sum);
        }
        return (int) (ans % 1000000007);
    }
}