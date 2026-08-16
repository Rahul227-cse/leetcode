class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] count = new int[3];
        for (int stone : stones) {
            count[stone % 3]++;
        }
        
        int c0 = count[0], c1 = count[1], c2 = count[2];
        
        if (c0 % 2 == 0) {
            return Math.min(c1, c2) >= 1;
        }
        
        return Math.abs(c1 - c2) > 2;
    }
}