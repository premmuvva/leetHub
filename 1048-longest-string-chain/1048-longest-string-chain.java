class Solution {
    int ans;
    Map<String, Integer> hm;
    public int longestStrChain(String[] words) {
        hm = new HashMap();
        Arrays.sort(words, (a, b) -> (a.length() - b.length()));
        if(words.length > 0) ans = 1;
        return process(words);
    }
    
    private int process(String[] words) {
        for (String str: words) {
            int k = str.length();
            if(!hm.containsKey(str)) hm.put(str, 1);
            for(int i = 0; i<k; i++) {
                String temp = str.substring(0, i) + str.substring(i+1, str.length());
                if(hm.containsKey(temp)) {
                    hm.put(str, Math.max(hm.get(str), hm.get(temp) + 1));
                }
            }
            ans = Math.max(ans, hm.get(str));
        }
        return ans;
    }
}