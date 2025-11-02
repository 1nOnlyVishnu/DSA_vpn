class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int n = nums.length - 1;
        int high = n;

        if(nums.length == 1){
            return 0;
        }

        while(low <= high){
            int mid = high + (low - high)/2;

            if(mid > 0 && mid < n){
                if(nums[mid]> nums[mid - 1] && nums[mid]>nums[mid+1]){
                    return mid;
                }else if(nums[mid - 1] > nums[mid]){
                    high = mid - 1;
                }else {
                    low = mid + 1;
                }
            }else if(mid == 0){
                if(nums[mid] > nums[mid + 1]){
                    return mid;
                }else{
                    return mid + 1;
                }
            }else if(mid == n){
                if(nums[mid] > nums[mid - 1]){
                    return mid;
                }else{
                    return mid - 1;
                }
            }
        }

        return -1;
    }
}