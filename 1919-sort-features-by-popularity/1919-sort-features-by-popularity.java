class Solution {
    public String[] sortFeatures(String[] features, String[] responses) {
        int n = features.length;
        Map<String, Integer> hm = new HashMap();
        for (int i = 0; i<n; i++) {
            hm.put(features[i], n-i);
        }
        int n1 = responses.length;
        HashSet<String> vis;
        for (int i = 0; i<n1; i++) {
            String[] str = responses[i].split(" ");
            vis = new HashSet();
            for (int j = 0; j<str.length; j++) {
                if (!vis.contains(str[j]) && hm.containsKey(str[j])) {
                    hm.put(str[j], hm.get(str[j]) + 10001);
                }
                vis.add(str[j]);
            }
        }
        int n2= hm.size();
        String[] ans = new String[n2];
        int i = 0;

        for(String str : hm.keySet()) {
            ans[i++] = str;
        }

        Arrays.sort(ans, (a, b) -> hm.get(b) - hm.get(a));
        // List<String> ans = hm.keySet().stream().toList().reverse();
        return ans;
    }
}