// class Solution {
//     private boolean BS(int[] nums, int index1, int index2, int target) {
//         while (index1 <= index2) {
//             int mid = index1 + (index2 - index1) / 2;

//             if (target == nums[mid]) {
//                 return true;
//             } else if (target < nums[mid]) {
//                 index2 = mid - 1;
//             } else {
//                 index1 = mid + 1;
//             }
//         }
//         return false;
//     }

//     private int findMinIndex(int[] nums) {
//         int start = 0;
//         int end = nums.length - 1;
//         int n = nums.length;

//         if (start == end) return start;
//         if (nums[start] < nums[end]) return start;

//         while (start <= end) {
//             int mid = start + (end - start) / 2;
//             int next = (mid + 1) % n;
//             int prev = (mid + n - 1) % n;

//             // handle duplicates
//             if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
//                 start++;
//                 end--;
//                 continue;
//             }

//             if (nums[mid] <= nums[prev] && nums[mid] <= nums[next]) {
//                 return mid;
//             } else if (nums[mid] >= nums[start]) {
//                 start = mid + 1;
//             } else {
//                 end = mid - 1;
//             }
//         }
//         return 0;
//     }

//     public boolean search(int[] nums, int target) {
//         int n = nums.length - 1;
//         int index = findMinIndex(nums);

//         boolean flag1 = BS(nums, index, n, target);
//         boolean flag2 = BS(nums, 0, index - 1, target);

//         if (flag1) return true;
//         return flag2;
//     }
// }

class Solution {
  public boolean search(int[] nums, int target) {
    int l = 0;
    int r = nums.length - 1;

    while (l <= r) {
      final int m = (l + r) / 2;
      if (nums[m] == target)
        return true;
      if (nums[l] == nums[m] && nums[m] == nums[r]) {
        ++l;
        --r;
      } else if (nums[l] <= nums[m]) { // nums[l..m] are sorted
        if (nums[l] <= target && target < nums[m])
          r = m - 1;
        else
          l = m + 1;
      } else { // nums[m..n - 1] are sorted
        if (nums[m] < target && target <= nums[r])
          l = m + 1;
        else
          r = m - 1;
      }
    }

    return false;
  }
}
