class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;

    int firstOcc =  binarySearchForFirstOcc(nums,target);
    int secondOcc = binarySearchForSecondOcc(nums,target);

    int[] ans = {firstOcc,secondOcc};

    return ans;

    }

    public int binarySearchForFirstOcc(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        
        int ans = -1;

        while(start<=end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                ans = mid;
                end = mid - 1;
            }else if(nums[mid] >  target){
                end = mid -1;
            }else{
                start = mid + 1;
            }
        }

        return ans;
    }

    

    public int binarySearchForSecondOcc(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        
        int ans = -1;

        while(start<=end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                ans = mid;
                start = mid + 1;
            }else if(nums[mid] >  target){
                end = mid -1;
            }else{
                start = mid + 1;
            }
        }

        return ans;
    }
}