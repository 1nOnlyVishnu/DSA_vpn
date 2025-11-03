/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int binarySearchOnAsc(int target, MountainArray mountainArr, int low, int high) {
    while (low <= high) {
        int mid = low + (high - low) / 2;
        int midVal = mountainArr.get(mid);

        if (midVal == target) {
            return mid;
        } else if (midVal < target) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return -1;
}

    public int binarySearchOnDesc(int target, MountainArray mountainArr, int low, int high) {
    while (low <= high) {
        int mid = low + (high - low) / 2;
        int midVal = mountainArr.get(mid);

        if (midVal == target) {
            return mid;
        } else if (midVal > target) {
            // In descending order, larger values are on the left
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return -1;
}



    // public int findPeakElementIndex(MountainArray mountainArr){
    //     int low = 0;
    //     int high = mountainArr.length - 1;


    //     if(mountainArr.length == 1){
    //         return 0;
    //     }

    //     while(low <= high){
    //         int mid  =  high + (low - high)/2;

    //         if(mid > 0 && mid < mountainArr.length -1){
    //             if(mountainArr[mid] > mountainArr[mid -1] && mountainArr[mid] > mountainArr[mid +1]){
    //                 return mid;
    //             }else if(mountainArr[mid - 1]> mountainArr[mid]){
    //                 high = mid -1;
    //             }else{
    //                 low = mid + 1;
    //             }
    //         }else if(mid == 0){
    //             if(mountainArr[mid] > mountainArr[mid+1]){
    //                 return mid;
    //             }else{
    //                 return mid + 1;
    //             }
    //         }else if(mid == mountainArr.length - 1){
    //             if(mountainArr[mid] > mountainArr[mid - 1]){
    //                 return mid;
    //             }else{
    //                 return mid - 1;
    //             }
    //         }
    //     }

    //     return -1;
    // }

    public int findPeakElementIndex(MountainArray mountainArr) {
    int low = 0;
    int high = mountainArr.length() - 1;

    while (low < high) {
        int mid = low + (high - low) / 2;

        int midVal = mountainArr.get(mid);
        int rightVal = mountainArr.get(mid + 1);

        // If we're on the descending slope
        if (midVal > rightVal) {
            high = mid; // peak is here or to the left
        } else {
            low = mid + 1; // still ascending, move right
        }
    }

    // low == high → this is the peak index
    return low;
}

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peakIndex = findPeakElementIndex(mountainArr);
        int index1 = binarySearchOnAsc(target,mountainArr,0,peakIndex -1);
        if (index1 >= 0) return index1;

return binarySearchOnDesc(target, mountainArr, peakIndex, mountainArr.length() - 1);
        // int index2 = binarySearchOnDesc(target,mountainArr,peakIndex,mountainArr.length() - 1);

        // if(index1 > 0){
        //     return index1;
        // }else{
        //     return index2;
        // }

    }
}