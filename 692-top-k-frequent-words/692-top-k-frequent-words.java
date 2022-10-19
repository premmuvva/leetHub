class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> hm = new HashMap();
        for (String i: words) hm.merge(i, 1, Integer::sum);
        Queue<String> heap = new PriorityQueue((a, b) -> (hm.get(b) - hm.get(a) == 0 ? ((String)a).compareTo((String)b) : hm.get(b) - hm.get(a)));
        for (String key : hm.keySet()) heap.add(key);
        List<String> arr = new ArrayList();
        for (int i = 0; i< k; i++) {
            arr.add(heap.poll());
        }
        return arr;
    }
}