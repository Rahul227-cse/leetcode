import java.util.HashMap;
import java.util.Map;

class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        if (k == 1) {
            Map<Integer, Integer> freq = new HashMap<>();
            for (int num : nums) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }
            int ans = -1;
            for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                if (entry.getValue() == 1) {
                    ans = Math.max(ans, entry.getKey());
                }
            }
            return ans;
        }

        if (k == n) {
            int ans = -1;
            for (int num : nums) {
                ans = Math.max(ans, num);
            }
            return ans;
        }
        int countFirst = 0;
        int countLast = 0;
        for (int num : nums) {
            if (num == nums[0]) countFirst++;
            if (num == nums[n - 1]) countLast++;
        }

        int ans = -1;
        if (countFirst == 1) ans = Math.max(ans, nums[0]);
        if (countLast == 1) ans = Math.max(ans, nums[n - 1]);

        return ans;
    }
}