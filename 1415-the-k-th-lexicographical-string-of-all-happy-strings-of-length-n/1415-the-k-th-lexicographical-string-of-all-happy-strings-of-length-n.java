class Solution {
    public String getHappyString(int n, int k) {
        int total = 3 * (1 << (n - 1));
        if (k > total) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        k--;

        int partitionSize = 1 << (n - 1);
        int choice = k / partitionSize;
        sb.append((char) ('a' + choice));
        k %= partitionSize;

        for (int i = n - 2; i >= 0; i--) {
            partitionSize = 1 << i;
            choice = k / partitionSize;
            k %= partitionSize;

            char prev = sb.charAt(sb.length() - 1);
            int count = 0;
            
            for (char c = 'a'; c <= 'c'; c++) {
                if (c != prev) {
                    if (count == choice) {
                        sb.append(c);
                        break;
                    }
                    count++;
                }
            }
        }

        return sb.toString();
    }
}