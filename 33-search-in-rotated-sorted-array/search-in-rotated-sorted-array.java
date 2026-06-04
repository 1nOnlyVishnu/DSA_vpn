class Solution {

    private int findMinEleIndex(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }

    private int binarySearchHelper(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public int search(int[] nums, int target) {
        int n = nums.length;

        if (n == 0) {
            return -1;
        }

        int pivot = findMinEleIndex(nums);

        int left = binarySearchHelper(nums, 0, pivot - 1, target);
        if (left != -1) {
            return left;
        }

        return binarySearchHelper(nums, pivot, n - 1, target);
    }
}