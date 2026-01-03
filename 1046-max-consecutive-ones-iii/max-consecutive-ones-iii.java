class Solution {
    public int longestOnes(int[] nums, int k) {
        int windowStart = 0;
        int zeroCount = 0;
        int maxLength = 0;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            if (nums[windowEnd] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (nums[windowStart] == 0) {
                    zeroCount--;
                }
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }
}
