class Solution {
    class Node {
        Node[] nodes;
        int cou;
        public Node() {
            nodes = new Node[26];
            cou = 0;
        }
    }
    public int[] sumPrefixScores(String[] words) {
        Node head = new Node(), temp;
        int cv;
        for (String str: words) {
            temp = head;
            for (char ch: str.toCharArray()) {
                cv = ch - 'a';
                if (temp.nodes[cv] == null) {
                    temp.nodes[cv] = new Node();
                }
                temp.nodes[cv].cou++;
                temp = temp.nodes[cv];
            }
        }
        int i = 0, tc = 0, ans[] = new int[words.length];
        for (String str: words) {
            tc = 0;
            temp = head;
            for (char ch: str.toCharArray()) {
                cv = ch - 'a';
                tc += temp.nodes[cv].cou;
                temp = temp.nodes[cv];
            }
            ans[i++] = tc;
        }
        return ans;
    }
}