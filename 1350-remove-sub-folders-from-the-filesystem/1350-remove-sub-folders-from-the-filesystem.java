class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        int n = folder.length;
        List<String> ans = new ArrayList();
        for (int i = 0; i<n; i++) {
            String str = folder[i] + "/";
            ans.add(folder[i]);
            while(i < n -1 && folder[i+1].startsWith(str)) {
                i++;
            }
        }
        
        return ans;
    }
}