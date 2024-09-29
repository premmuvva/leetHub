class AllOne {

    PriorityQueue<Pair<String, Integer>> min, max;
    Map<String, Integer> hm;
    Set<String> th;
    public AllOne() {
        min = new PriorityQueue<Pair<String, Integer>>((a, b)-> a.getValue()-b.getValue());
        max = new PriorityQueue<Pair<String, Integer>>((a, b)-> b.getValue()-a.getValue());
        hm = new HashMap();
        th = new HashSet();
    }
    
    public void inc(String key) {
        th.add(key);
        hm.put(key, hm.getOrDefault(key, 0)+1);
    }
    
    public void dec(String key) {
        th.add(key);
        hm.put(key, hm.getOrDefault(key, 0)-1);
    }
    
    public String getMaxKey() {
        // if (th.size() == 0) {
        //     return max.size() == 0 ? "" : (max.peek().getValue() <= 0 ? "" : max.peek().getKey());
        // }
        for (String en : th) {
            min.offer(new Pair(en, hm.get(en)));
            max.offer(new Pair(en, hm.get(en)));
        }
        th = new HashSet();
        while(max.size() > 0 && max.peek().getValue() != hm.get(max.peek().getKey())) {
            max.poll();
        }
        return max.size() == 0 ? "" : (max.peek().getValue() <= 0 ? "" : max.peek().getKey());
    }
    
    public String getMinKey() {
        // if (th.size() == 0) {
        //     return min.size() == 0 ? "" : (min.peek().getValue() <= 0 ? "" : max.peek().getKey());
        // }
        for (String en : th) {
            min.offer(new Pair(en, hm.get(en)));
            max.offer(new Pair(en, hm.get(en)));
        }
        th = new HashSet();
        while(min.size() > 0 && (min.peek().getValue() != hm.get(min.peek().getKey()) || min.peek().getValue() <= 0)) {
            min.poll();
        }
        return min.size() == 0 ? "" : min.peek().getKey();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */