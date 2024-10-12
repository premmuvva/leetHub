class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n= nums.size(), i = 0;
        int[] ans = new int[n];
        for (int ii = 0; ii<n; ii++) {
            int cur = nums.get(ii);
            if ((cur & 1) != 1) {
                ans[i++] = -1;
                continue;
            }
            
            String bin = Integer.toBinaryString(cur);
            if (bin.contains("0")) {
                int lastZeroIndex = bin.lastIndexOf('0');
                bin = bin.substring(0, lastZeroIndex+1) + '0' + bin.substring(lastZeroIndex + 2);
                ans[i++] = Integer.parseInt(bin, 2);
            } else 
                ans[i++] = Integer.parseInt(bin.substring(1), 2);
            
        }
        return ans;
    }
}