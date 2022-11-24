class Solution {
    private class Trie {
        public Trie child[] = new Trie[26];
        boolean end;
        
    }
    private void insert(String word, Trie root) {
        Trie node = root;
        for (char ch : word.toCharArray()) {
            if (node.child[ch - 'a'] == null)
                node.child[ch-'a'] = new Trie();
            node = node.child[ch-'a'];
        }
        node.end = true;
    }
    private class Node {
        public Map<Character, List<Node>> node;
        public char ch;
        public boolean vis;
        
        public Node(char ch) {
            this.ch = ch;
            this.node = new HashMap();
            this.vis = false;
        }
        
        public void add(Node n) {
            if (!node.containsKey(n.ch)) {
                node.put(n.ch, new ArrayList());
            }
            node.get(n.ch).add(n);
        }
    }
    private Node generate_board_map(char[][] board) {
        Map<Pair<Integer, Integer>, Node> hm = new HashMap();
        int m = board.length, n = board[0].length, pos[][] = {{-1,0}, {0,1}, {1,0}, {0,-1}}, iii, jjj;
        Pair<Integer, Integer> cur_pair, pair;
        Node head = new Node('*');
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cur_pair = new Pair(i, j);
                if (!hm.containsKey(cur_pair)) {
                    hm.put(cur_pair, new Node(board[i][j]));
                }
                for (int[] ii : pos) {
                    iii = i + ii[0];
                    jjj = j + ii[1];
                    if (iii < 0 || iii >= m || jjj < 0 || jjj >= n) 
                        continue;
                    pair = new Pair(iii, jjj);
                    if (!hm.containsKey(pair)) {
                        hm.put(pair, new Node(board[i+ii[0]][j+ii[1]]));
                    }
                    hm.get(cur_pair).add(hm.get(pair));
                }
                head.add(hm.get(cur_pair));
            }
        }
        return head;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        for (String word : words)
            insert(word, root);
        
        Set<String> ans = new HashSet();
        Node bm = generate_board_map(board);
        solve(root, bm, ans, new StringBuilder());
        return new ArrayList(ans);
        
    }
    
    private void solve(Trie root, Node bm, Set<String> ans, StringBuilder cur) {
        bm.vis = true;
        if (root.end) ans.add(cur.toString());
        for (int i = 0; i < 26; i++) {
            if (root.child[i] != null) {
                char ch = (char) (i + 'a');
                if (bm.node.containsKey(ch)) {
                    cur.append(ch);
                    for (Node no : bm.node.get(ch)) {
                        if (!no.vis)
                            solve(root.child[i], no, ans, cur);
                    }
                    cur.setLength(cur.length() - 1);
                }           
            }
        }
        bm.vis = false;
    }
}