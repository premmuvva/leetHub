class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        Map<Integer, Set<Integer>> hs = new HashMap();
        Map<Integer, Set<Integer>> hs1 = new HashMap();
        for (int[] ed: invocations) {
            hs.computeIfAbsent(ed[0], dk-> new HashSet()).add(ed[1]);
            hs1.computeIfAbsent(ed[1], dk-> new HashSet()).add(ed[0]);
        }
        Set<Integer> sus = new HashSet(), na = new HashSet();
        Queue<Integer> pq = new LinkedList();
        pq.add(k);
        sus.add(k);
        while(!pq.isEmpty()) {
            int poll = pq.poll();
            if (hs.containsKey(poll)) {
                for(int tem: hs.get(poll)) {
                    if (!sus.contains(tem)) {
                        sus.add(tem);
                        pq.add(tem);
                    }
                }
            }   
        }
        Set<Integer> callers = new HashSet(), overlap;
        for (int i : sus) {
            if (hs1.containsKey(i)) {
                callers.addAll(hs1.get(i));
            }
        }
        overlap = new HashSet(callers);
        overlap.retainAll(sus);
        if (callers.size() == overlap.size()) {
           na = sus;
        }
        // System.out.println(hs);
        // System.out.println(hs1);
        // System.out.println(sus);
        // System.out.println(callers);
        List<Integer> ans = new ArrayList();
        for (int i = 0; i<n; i++) {
            if (!na.contains(i)) ans.add(i);
        }
        return ans;
    }
}