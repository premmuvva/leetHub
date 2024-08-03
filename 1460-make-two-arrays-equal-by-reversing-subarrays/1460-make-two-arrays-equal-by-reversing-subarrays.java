class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int i, nt = target.length;
        Arrays.sort(target);
        Arrays.sort(arr);
        
        for (i = 0; i < nt; i++) {
            if (target[i] != arr[i]) return false;
        }
        
        // Map<Integer, Integer> hm = new HashMap();
        // for (i = 0; i<nt; i++) {
        //     hm.put(target[i], hm.getOrDefault(target[i], 0) + 1);
        // }
        // try {
        //     for (i = 0; i<nt; i++) {
        //         hm.put(arr[i], hm.get(arr[i]) - 1);
        //         if(hm.get(arr[i]) < 0) {
        //             return false;
        //         }
        //     }
        // } catch (Exception e) {
        //     return false;
        // }
        return true;
    }
}