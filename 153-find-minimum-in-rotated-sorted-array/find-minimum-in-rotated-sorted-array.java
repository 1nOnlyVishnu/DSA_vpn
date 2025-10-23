class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int n = nums.length;

        if(start == end){
            return nums[start];
        }

        if(nums[start] <= nums[end]){
            return nums[start];
        }

        while(start<=end){
            int mid = start +(end - start) /2;
            int next = (mid + 1) % n;
            int prev = (mid + n - 1) % n;

            if(nums[mid] <= nums[prev] && nums[mid]<= nums[next]){
                return nums[mid];
            }else if(nums[0] <= nums[mid]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
            
        }
        return -1;
    }
}