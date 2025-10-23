class Solution {
    private int BS(int[] nums,int index1,int index2,int target){
        while(index1<=index2){
            int mid = index1 + (index2 - index1)/2;

            if(target == nums[mid]){
                return mid;
            }else if(target<nums[mid]){
                index2 = mid - 1;
            }else{
                index1 = mid + 1;
            }
        }

        return -1;
    }

    private int findMinIndex(int[] nums,int target){
        int start = 0;
        int end = nums.length - 1;
        int n = nums.length;

        

        if(start == end) return start;

        if(nums[start] <= nums[end]) return start;

        while(start<=end){
            int mid = start + (end - start)/2;
            int next = (mid + 1)%n;
            int prev = (mid + n - 1) %n;

            if(nums[mid] <= nums[prev] && nums[mid] <= nums[next]){
                return mid;
            }else if(nums[0] <= nums[mid]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int start = 0;
        if(nums[start] == target) return start;
        int n =nums.length - 1;
        int index = findMinIndex(nums,target);

        int num1 = BS(nums,index,n,target);
        int num2 = BS(nums,0,index-1,target);

        if(num1>0){
            return num1;
        }

        return num2;
    }
}