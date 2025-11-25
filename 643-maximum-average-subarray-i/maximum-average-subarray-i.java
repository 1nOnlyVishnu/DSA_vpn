class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int windowStart = 0;
        int windowEnd = 0;
        double avg = 0.0;
        double sum = 0.0;
        double maxAvg = Double.NEGATIVE_INFINITY;

        while(windowEnd < nums.length){
            sum = sum + nums[windowEnd];
            if(windowEnd - windowStart + 1 < k){
                windowEnd++;
            }else if(windowEnd - windowStart + 1 == k){
                avg = sum / k;
                maxAvg = Math.max(avg,maxAvg);
                sum = sum - nums[windowStart];
                windowStart++;
                windowEnd++;
            }
        }

        return maxAvg;
    }
}