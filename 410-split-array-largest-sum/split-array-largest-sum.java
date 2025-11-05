class Solution {
    public int splitArray(int[] nums, int k) {

        int n = nums.length;
        if(n<k) return -1;

        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        int max = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }

        int start = max;
        int end = sum;
        int res = -1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(isValid(nums,k,mid) == true){
                res = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return res;
    }

    public boolean isValid(int[] nums,int k,int max){
        int n = nums.length;

        int student  = 1;
        int sum = 0;

        for(int i=0;i<n;i++){
            sum = sum + nums[i];
            if(sum > max){
                student++;
                sum = nums[i];
            }
        

        if(student > k){
            return false;
        }
        }

        return true;
    }
}