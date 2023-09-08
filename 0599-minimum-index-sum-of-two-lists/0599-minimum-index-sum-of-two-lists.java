class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> hm = new HashMap();
        int i = 0;
        for (String str: list1) {
            hm.put(str, i++);
        }
        int ans = 200000, temp;
        List<String> strans = new ArrayList();
        for (i = 0; i < list2.length; i++) {
            String l2e = list2[i];
            if (hm.containsKey(l2e)) {
                temp = i + hm.get(l2e);
                if (ans > temp) {
                    ans = temp;
                    strans = new ArrayList();
                    strans.add(l2e);
                } else if (ans == temp) strans.add(l2e);
            }
        }
        return strans.toArray(new String[0]);
    }
}