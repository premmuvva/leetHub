class Solution {
    public int countGoodNodes(int[][] edges) {
        Map<Integer, List<Integer>> nodeMap = new HashMap<>();
        Set<Integer> childNodes = new HashSet<>();
        Set<Integer> allNodes = new HashSet<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            nodeMap.putIfAbsent(u, new ArrayList<>());
            nodeMap.get(u).add(v);
            nodeMap.putIfAbsent(v, new ArrayList<>());
            nodeMap.get(v).add(u);
            
            allNodes.add(u);
            allNodes.add(v);
            
            childNodes.add(v);
        }
        Integer rootNode = 0;
        int [] size = new int[allNodes.size()], ans = new int[allNodes.size()];
        // System.out.println(nodeMap);
        
        countNodes(nodeMap, rootNode, -1, size, ans);
        // System.out.println(Arrays.toString(ans));
        // System.out.println(Arrays.toString(size));
        return ans[0];
    }

    private void countNodes(Map<Integer, List<Integer>> nodeMap, Integer root, int parent, int [] size, int[] ans) {
        size[root] = 1;
        if (nodeMap.get(root) == null || nodeMap.get(root).size() == 0) {
            ans[0]++;
            return;
        }
        List<Integer> childSizes = new ArrayList<>();
        for (int child: nodeMap.get(root)) {
            if (child == parent) {
                continue;
            }
            countNodes(nodeMap, child, root, size, ans);
            size[root] += size[child];
            childSizes.add(size[child]);
        }
        // System.out.println(root);
        // System.out.println(childSizes);
        size[root]++;
        if (childSizes.size() > 0) {
            int firstChildSize = childSizes.get(0);
            boolean isGoodNode = childSizes.stream().allMatch(s -> s == firstChildSize);
            if (isGoodNode) {
                ans[0]++;
            }
        } else {
            ans[0]++;
        }
    }

}