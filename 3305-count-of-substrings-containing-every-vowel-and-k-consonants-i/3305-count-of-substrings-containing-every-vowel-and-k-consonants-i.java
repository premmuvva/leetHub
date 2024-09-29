class Solution {
    public int countOfSubstrings(String word, int k) {
        // int arr[] = new int[26];
        int n =word.length(), vc = 0, st = 0, ans = 0;

        for (int i = 0; i< n; i++) {
            vc = 0;
            int arr[] = new int[26];
            for (int j = i; j<n; j++) {
                if (isVowel(word.charAt(j))) {
                    arr[word.charAt(j)- 'a']++;
                } else {
                    vc++;
                } 
                if (vc == k) {
                    if (arr[0] != 0 && arr[4] != 0 && arr[8] != 0 && arr[14] != 0 && arr[20] != 0) {
                        // System.out.printf("%s\n", word.substring(i, j+1));
                        ans++;
                    }
                } else if(vc > k) break;
            }
        }
        return ans;
    }

    boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}