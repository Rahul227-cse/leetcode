class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] lastIdx = new int[m];
        int p = n - 1;
        for (int j = m - 1; j >= 0; j--) {
            while (p >= 0 && word1.charAt(p) != word2.charAt(j)) {
                p--;
            }
            lastIdx[j] = p;
            if (p >= 0) {
                p--; 
            }
        }

        int[] result = new int[m];
        boolean usedEdit = false;
        int i = 0;
        for (int j = 0; j < m; j++) {
            boolean matched = false;
            while (i < n) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    result[j] = i;
                    i++;
                    matched = true;
                    break;
                } else if (!usedEdit) {
                    if (j == m - 1 || (lastIdx[j + 1] != -1 && lastIdx[j + 1] > i)) {
                        usedEdit = true;
                        result[j] = i;
                        i++;
                        matched = true;
                        break;
                    }
                }
                i++;
            }
            if (!matched) {
                return new int[0];
            }
        }

        return result;
    }
}