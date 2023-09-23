class Solution {
    int ans;
    Map<String, Integer> hm;
    public int longestStrChain(String[] words) {
        hm = new HashMap();
        TreeMap<Integer, List<String>> tm = new TreeMap<Integer, List<String>>(Collections.reverseOrder());
        for(String str: words) {
            if(!tm.containsKey(str.length())) {
                tm.put(str.length(), new ArrayList());
            }
            tm.get(str.length()).add(str);
        }
        int val = tm.firstKey() - 1;
        // for(String str: tm.firstEntry().getValue().toArray()) {
        //     ans = Math.max(ans, process(tm.firstKey() - 1, tm, str));
        // }
        if(words.length > 0) ans = 1;
        return process(tm);
    }
    
    private int process(TreeMap<Integer, List<String>> tm) {
        for (Map.Entry<Integer, List<String>> entry: tm.entrySet() ) {
            for (String str: entry.getValue()) {
                int k = str.length();
                if(!hm.containsKey(str)) hm.put(str, 1);
                for(int i = 0; i<k; i++) {
                    String temp = str.substring(0, i) + str.substring(i+1, str.length());
                    if(!tm.containsKey(k -1)) break;
                    if(tm.get(k-1).contains(temp)) {
                        if(!hm.containsKey(temp)) hm.put(temp, 0);
                        hm.put(temp, Math.max(hm.get(temp), hm.get(str) + 1));
                        ans = Math.max(ans, hm.get(temp));
                    }
                }
            }
        }
        return ans;
    }
}