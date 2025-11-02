class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int low  = 0;
        int high = arr.length - 1;

        if(arr.length == 1){
            return 0;
        }

        while(low <= high){
            int mid  = high + (low - high)/2;

            if(mid > 0 && mid < arr.length - 1){
                if(arr[mid] > arr[mid -1] && arr[mid] > arr[mid + 1]){
                    return mid;
                }else if(arr[mid - 1] >  arr[mid]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else if(mid == 0){
                if(arr[mid] > arr[mid + 1]){
                    return mid;
                }else{
                    return mid + 1;
                }
            }else if(mid == arr.length - 1){
                if(arr[mid] > arr[mid -1]){
                    return mid;
                }else{
                    return mid - 1;
                }
            }
        }

        return -1;
    }
}