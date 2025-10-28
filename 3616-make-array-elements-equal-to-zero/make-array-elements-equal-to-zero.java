class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        long totalSum = 0;
        for (int x : nums) {
            totalSum += x;
        }
        long leftSum = 0;
        int result = 0;
    
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                long rightSum = totalSum - leftSum;
                if (leftSum == rightSum) {
                    result += 2;
                } else if (Math.abs(leftSum - rightSum) == 1) {
                    result += 1;
                }
            }
            leftSum += nums[i];
        }
        return result;
    }
}
