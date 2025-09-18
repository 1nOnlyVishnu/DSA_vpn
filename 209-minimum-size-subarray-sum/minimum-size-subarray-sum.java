class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int windowSum = 0; //sum of sliding window ---> changes again n again

        int windowStart = 0; //start pointer
        int minLengthOfSubArray = Integer.MAX_VALUE;
        for(int windowEnd = 0;windowEnd < nums.length;windowEnd++){
            windowSum += nums[windowEnd];

            while(windowSum >= target){
                minLengthOfSubArray = Math.min(minLengthOfSubArray,windowEnd - windowStart + 1);
                windowSum -= nums[windowStart];
                windowStart++;
            }
        }

        return minLengthOfSubArray == Integer.MAX_VALUE ? 0 : minLengthOfSubArray;
        
    }
}