class Solution {
    private int firstOcc(int[] nums,int target){
        int start = 0;
        int end = nums.length - 1;

        int res = -1;
        
        while(start<=end){
            int mid = start + (end-start)/2;
            if(target == nums[mid]){
                res = mid;
                end = mid -1;
            }else if(target < nums[mid]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return res;
    }

        private int lastOcc(int[] nums,int target){
        int start = 0;
        int end = nums.length - 1;

        int res = -1;
        
        while(start<=end){
            int mid = start + (end-start)/2;
            if(target == nums[mid]){
                res = mid;
                start = mid + 1;
            }else if(target < nums[mid]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return res;
    }

    public int[] searchRange(int[] nums, int target) {
        int index1 = firstOcc(nums,target);
        int index2 = lastOcc(nums,target);

        int[] ans = {index1,index2};

        return ans;
    }
}