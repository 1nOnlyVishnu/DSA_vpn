class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;

        int start = 0;
        int end = n -1;
        boolean found = false;
        int ans = -1;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                found = true;
                ans =  mid;
                break;
            }else if(nums[mid] >  target){
                end = mid - 1;
            }else{
                start = mid+1;
            }
        }

if(found){
    return ans;
}else{
    int[] newArr = new int[nums.length + 1];
   
    for(int i = 0 ;i<n;i++){
            newArr[i] = nums[i];
    }

     newArr[start] = target;

     for (int i = start; i < n; i++) {
                newArr[i + 1] = nums[i];
            }
}
return start;
        
    }
}