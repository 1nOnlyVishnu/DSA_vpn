class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
       
        // for(int i = 0;i<n;i++){
        //     int count = 0;
        //     for(int j =0;j<n;j++){
        //         if(nums[j] == nums[i]){
        //             count++;
        //         }
        //     }
        //     if(count >  n/2)
        //         return nums[i];
        // }

        // return -1;

        int count = 0;
        int majEle = Integer.MAX_VALUE;

    for(int i = 0;i<n;i++){
        if(nums[i] == majEle){
            count++;
        }else if(count == 0){
            majEle = nums[i];
            count = 1;
        }else{
           count--;
        }
    }
    return majEle;
    }
}