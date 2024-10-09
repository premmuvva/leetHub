class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] sp1 = sentence1.split(" "), sp2 = sentence2.split(" ");
        if (sp1.length > sp2.length) {
            sp1 = sentence2.split(" ");
            sp2 = sentence1.split(" ");
        }
        int n1 = sp1.length, n2 = sp2.length, i = 0, j = 0;
        boolean flag = true;
        int gap = -1;
        while(i < n1 && j < n2 && sp1[i].equals(sp2[j])) {
            i++; j++;
        }
        n1--; n2--;
        while(i <= n1 && j <= n2 && sp1[n1].equals(sp2[n2])) {
            n1--; n2--;
        }
        return i > n1;
    }
}