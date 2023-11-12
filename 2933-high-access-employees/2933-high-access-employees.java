class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        Map<String, List<Integer>> hm = new HashMap();
        for (List<String> en: access_times) {
            if(!hm.containsKey(en.get(0))) hm.put(en.get(0), new ArrayList());
            int n = Integer.parseInt(en.get(1));
            hm.get(en.get(0)).add((n/100)*60 + (n%100));
        }
        List<String> ans = new ArrayList();
        int i;
        for(Map.Entry<String, List<Integer>> en: hm.entrySet()) {
            i = 0;
            List<Integer> val = en.getValue();
            Collections.sort(val);
            if(val.size() < 3) continue;
            for(int j = 2; j<val.size(); j++) {
                if(val.get(j) - val.get(j-2) < 60) {
                    ans.add(en.getKey());
                    break;
                }
            }
        }
        return ans;
    }
}