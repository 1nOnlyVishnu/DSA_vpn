class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double avg = Double.NEGATIVE_INFINITY;
        double ans = 0.0;
        // if(nums.length == 1){
        //    ans =  nums[0]/1;
        //    return ans;
        // }

        int i = 0;
        int j = 0;

        while(j<nums.length){
          ans += nums[j];

            if((j-i+1) < k){
                j++;
            }else if((j-i+1) == k){
                avg = Math.max(avg,ans/k);
                ans -= nums[i];
                i++;
                j++;
            }
        }

        return avg;
    }
}