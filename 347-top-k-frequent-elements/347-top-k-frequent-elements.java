class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap();
        for (int i: nums) hm.merge(i, 1, Integer::sum);
        Queue<Integer> heap = new PriorityQueue((a, b) -> hm.get(b) - hm.get(a));
        for (int key : hm.keySet()) heap.add(key);
        int arr[] = new int [k];
        for (int i = 0; i< k; i++) {
            arr[i] = heap.poll();
        }
        return arr;
    }
}