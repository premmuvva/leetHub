class SparseVector {

    public Map<Integer, Integer> hm;
    
    SparseVector(int[] nums) {
        hm = new HashMap();
        for (int i =0 ; i< nums.length; i++) {
            if (nums[i] != 0) hm.put(i, nums[i]);
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        Map<Integer, Integer> vechm = vec.hm;
        int ans = 0;
        for (Map.Entry<Integer, Integer> en: this.hm.entrySet()) {
            if (vechm.containsKey(en.getKey())) {
                ans += en.getValue()*vechm.get(en.getKey());
            }
        }
        return ans;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);