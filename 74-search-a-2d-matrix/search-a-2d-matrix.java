class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        // int m = matrix.length;
        // for(int i = 0;i<m;i++){
        //     int n = matrix[i].length;
        //     for(int j = 0;j<n;j++){
        //         if(matrix[i][j] == target){
        //             return true;
        //         }
        //     }
        // }

        // return false;
        int m = matrix.length;
        

        for(int i =0 ;i<m;i++){
            int n = matrix[i].length;
            if(matrix[i][0] <= target && target<=matrix[i][n-1]){
                return BinarySearch(matrix[i],target);
            }
        }
        return false; 
    }

    public boolean BinarySearch(int[] arr,int target){
        int low = 0;
        int high =  arr.length - 1;
        

    while(low<=high){
        int mid = (low+high)/2;
        if(target == arr[mid]){
                return true;
        }else if(target>arr[mid]){
            low = mid+1;
        }else{
            high = mid - 1;
        }
    }

    return false;    
    }
}