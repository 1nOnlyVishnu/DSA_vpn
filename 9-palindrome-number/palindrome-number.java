class Solution {
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);//"123"

        char[] arr = str.toCharArray(); // 1,2,3,1

        int left = 0;
        int right = arr.length - 1;

        while(left <= right){
            if(arr[left] != arr[right]){
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}