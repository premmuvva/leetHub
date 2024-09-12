class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> hm = new HashMap();
        for (String s: arr) {
            hm.merge(s, 1, (v1, v2) -> v2 + v1);
        }
        for (String s: arr) {
            if (hm.get(s) == 1) {
                if (k == 1)
                    return s;
                k--;
            }
        }
        // System.out.println(hm);
        return "";
    }
}