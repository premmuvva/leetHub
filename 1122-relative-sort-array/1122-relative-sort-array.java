class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int cur = 0, temp;
        Map<Integer, Integer> hm = new TreeMap();
        for (int i : arr1) 
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        for(int i : arr2) {
            int count = hm.getOrDefault(i, 0);
            hm.remove(i);
            for (int j = 0; j < count; j++) {
                arr1[cur++] = i;
            }

            // for (int j = cur; j < arr1.length; j++) {
            //     if(i == arr1[j]) {
            //         arr1[j] = arr1[cur];
            //         arr1[cur++] = i;
            //     }
            // } 
        }
        for(Map.Entry<Integer, Integer> entry: hm.entrySet()) {
            int count = entry.getValue();
            int i = entry.getKey();
            for (int j = 0; j < count; j++) {
                arr1[cur++] = i;
            }
        }
        return arr1;
    }
}