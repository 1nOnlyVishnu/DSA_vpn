class Solution {
    public void sortColors(int[] nums) {
        int count_0 = 0;
        int count_1 = 0;
        int  count_2 = 0;
         for(int i : nums){
            if( i == 0){
                count_0++;
            }else if(i == 1){
                count_1++;
            }else if(i == 2){
                count_2++;
            }
         }

         int k = 0;
         while(count_0>0){
            nums[k] = 0;
            k++;
            count_0--;
         }

         while(count_1 > 0){
            nums[k] = 1;
            k++;
            count_1--;
         }

          while(count_2 > 0){
            nums[k] = 2;
            k++;
            count_2--;
         }
        
    }
}