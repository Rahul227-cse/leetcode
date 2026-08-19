import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> reservedMap = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            if (col >= 2 && col <= 9) {
                reservedMap.put(row, reservedMap.getOrDefault(row, 0) | (1 << col));
            }
        }
        int totalGroups = 2 * (n - reservedMap.size());

        int leftMask   = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5);
        int rightMask  = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9);
        int middleMask = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7);

        for (int reserved : reservedMap.values()) {
            boolean canFitLeft   = (reserved & leftMask) == 0;
            boolean canFitRight  = (reserved & rightMask) == 0;
            boolean canFitMiddle = (reserved & middleMask) == 0;

            if (canFitLeft && canFitRight) {
                totalGroups += 2;
            } else if (canFitLeft || canFitRight || canFitMiddle) {
                totalGroups += 1;
            }
        }

        return totalGroups;
    }
}