class Solution {
    public String findDifferentBinaryString(String[] nums) {
       StringBuilder result = new StringBuilder();

       for (int i = 0; i < nums.length; i++){
            char bit = nums[i].charAt(i);

            if(bit == '0'){
                result.append('1');
            }else{
                result.append('0');
            }
       }

       return result.toString();
    }
}