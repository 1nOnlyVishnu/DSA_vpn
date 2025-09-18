class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;

        // build the first window
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;

        // slide the window
        for (int windowEnd = k; windowEnd < nums.length; windowEnd++) {
            sum += nums[windowEnd] - nums[windowEnd - k];
            maxSum = Math.max(maxSum, sum);
        }

        return (double) maxSum / k;
    }
}
