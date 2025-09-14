class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while(left<right){
            //not a alphabet or a digit... so it means its a special character so skip processing.
            // this is done from 0th index using left pointer.
            while(left<right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }

            //same thing from n-1th index using right pointer
            while(left<right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }

            if(Character.toLowerCase(s.charAt(left))!= Character.toLowerCase(s.charAt(right))){
                return false;
            }

            left++;
            right--;


        }

        return true;
    }
}