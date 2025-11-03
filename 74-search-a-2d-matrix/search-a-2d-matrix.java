class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
        int m = arr.length;
        int n = arr[0].length;
        int i = 0;

        int j = n -1;

        while(i>=0 && i <m && j>=0 && j< n){
            if(arr[i][j] == target){
                return true;
            }else if(arr[i][j] > target){
                j--;
            }else if(arr[i][j] < target){
                i++;
            }
        }

        return false;
    }
}