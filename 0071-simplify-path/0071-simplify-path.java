class Solution {
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        Deque<String> stack = new ArrayDeque();
        for(String str: split) {
            if (str.equals("") || str.equals(".")) {
                continue;
            } else if (str.equals("..")) {
                stack.pollLast();
            } else {
                stack.offer(str);
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()) {
            ans.append("/").append(stack.poll());
        }
        return ans.length() == 0 ? "/" : ans.toString();
    }
}