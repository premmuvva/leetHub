class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        // Map<Integer, Integer> hm = new HashMap();
        // Comparator<Integer> valueComparator = new Comparator<Integer>() { 
        //           public int compare(Integer k1, Integer k2)  { 
        //               int comp = hm.get(k2).compareTo( 
        //                   hm.get(k1)); 
        //               if (comp == 0) 
        //                   return k2-k1; 
        //               else
        //                   return comp; 
        //           } 
        //       }; 
        // for (int i: nums) {
        //     hm.put(i, hm.getOrDefault(i, 0)+1);
        // }
        // Map<Integer, Integer> sorted = new TreeMap<Integer, Integer>(valueComparator);
        // sorted.putAll(hm);
        // System.out.println(sorted);
        // List<Map.Entry<Integer, Integer>> en = new ArrayList(hm.entrySet());
        // Collections.sort(en, Map.Entry.comparingByKey());
        // int i = 0;
        // for(Map.Entry<Integer, Integer> temp : en) {
        //     if (i == x) break;
        // }
        // return new int[0];

        // int n = nums.length;
        // int[][] dp = new int[n][2];
        // Map<Integer, Integer> hm = new HashMap();
        // for (int i = 0; i<k-1; i++) {
        //     hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);
        // }
        // int i = 0;
        // for (Map.Entry<Integer, Integer> en : hm.entrySet()) {
        //     dp[i][0] = en.getKey();
        //     dp[i][1] = en.getValue();
        //     i++;
        // }
        // System.out.println(hm);
        // Arrays.sort(dp, (a, b) -> {
        //     if (a[1] == b[1]) return b[0]-a[0];
        //     return b[1]-a[1];
        // });
        // int co = i;
        // for (i = co -1; i>=0; i--) {
        //     hm.put(dp[i][0], i);
        // }
        // System.out.println(hm);

        // for (i = k; i<n; i++) {

        // }

        // for (int[] row : dp) {
        //     System.out.println(Arrays.toString(row));
        // }

        // int[] ans = new int[n];
        // return ans;
        
        int n = nums.length;
        int [] ans = new int[n-k+1];
        int sum = 0;
        Map<Integer, Integer> hm = new HashMap();
        
        for (int i = 0 ; i<k-1 ;i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);
        }

        int cur = 0;
        for (int i = k-1; i < n; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);
            List<Map.Entry<Integer, Integer>> elist = hm.entrySet().stream().sorted((a, b) -> {
                if (a.getValue() == b.getValue()) return b.getKey()-a.getKey();
                return b.getValue()-a.getValue();
            }).collect(Collectors.toList());
            
            ans[cur++] = hm.entrySet().stream().sorted((a, b) -> {
                if (a.getValue() == b.getValue()) return b.getKey()-a.getKey();
                return b.getValue()-a.getValue();
            }).limit(x)//.peek(System.out::println)
            .map(kk -> kk.getKey() * kk.getValue()).mapToInt(Integer::intValue).sum();
            // System.out.println(elist);
            hm.put(nums[i-k+1], hm.get(nums[i-k+1])-1);
        }
        return ans;


    }
    private int[] findMostFrequent(HashMap<Integer, Integer> frequencyMap) {
        int maxFreq = 0;
        int mostFrequentValue = -1;

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                mostFrequentValue = entry.getKey();
            }
        }

        return new int[]{mostFrequentValue}; 
    }
}