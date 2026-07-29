class Solution {
    public String smallestPalindrome(String s, int k) {
        int n = s.length();
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        int[] half = new int[26];
        char midChar = 0;
        for (int i = 0; i < 26; i++) {
            half[i] = count[i] / 2;
            if (count[i] % 2 != 0) {
                midChar = (char) ('a' + i);
            }
        }

        int halfLen = n / 2;
        StringBuilder firstHalf = new StringBuilder();

        for (int i = 0; i < halfLen; i++) {
            boolean matched = false;
            for (int c = 0; c < 26; c++) {
                if (half[c] == 0) continue;

                half[c]--;
                long ways = countPermutations(half, k);

                if (ways >= k) {
                    firstHalf.append((char) ('a' + c));
                    matched = true;
                    break;
                } else {
                    k -= ways;
                    half[c]++; 
                }
            }
            if (!matched) {
                return "";
            }
        }

        StringBuilder secondHalf = new StringBuilder(firstHalf).reverse();
        if (n % 2 != 0) {
            firstHalf.append(midChar);
        }
        firstHalf.append(secondHalf);

        return firstHalf.toString();
    }

    private long countPermutations(int[] cnt, long limit) {
        int total = 0;
        for (int c : cnt) total += c;

        long ways = 1;
        int rem = total;
        for (int c : cnt) {
            if (c == 0) continue;
            ways *= nCr(rem, c, limit);
            if (ways >= limit) return limit;
            rem -= c;
        }
        return ways;
    }

    private long nCr(int n, int r, long limit) {
        if (r < 0 || r > n) return 0;
        if (r == 0 || r == n) return 1;
        if (r > n - r) r = n - r;

        long res = 1;
        for (int i = 1; i <= r; i++) {
            res = res * (n - i + 1) / i;
            if (res >= limit) return limit;
        }
        return res;
    }
}