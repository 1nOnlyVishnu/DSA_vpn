class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        Arrays.sort(nums);
        
        long totalSum = 0;
        int n = nums.length;

        for(int i = 0; i < k; i++){
            long element = nums[n-1-i];

            long optionA = element;
            long optionB = element * mul;

            totalSum += Math.max(optionA, optionB);
            mul--;
        }

        return totalSum;
    }
}