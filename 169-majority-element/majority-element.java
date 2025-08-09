class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        // int first = 0;
        // int last = n - 1;
        

        // while(first<=last){
        //     if(nums[first] >= nums[last]){
        //          return nums[first++];
        //     }else{
        //         return nums[last--];
        //     }
        // }



        // while(first<= last){
        //     if(nums[first] > times){
        //         int temp = nums[first];
        //         first++;
        //         return temp;
        //     }else if(nums[first] == times) {
        //         return nums[first] ;
        //     }
        //     else{
        //         int temp = nums[last];
        //         last--;
        //         return temp;
        //     }
        // }

        // return 0;

        for(int i = 0;i<n;i++){
            int count = 0;
            for(int j =0;j<n;j++){
                if(nums[j] == nums[i]){
                    count++;
                }
            }
            if(count >  n/2)
                return nums[i];
        }

        return -1;
    }
}