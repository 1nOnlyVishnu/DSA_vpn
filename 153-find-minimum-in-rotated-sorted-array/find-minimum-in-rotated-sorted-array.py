class Solution:
    def findMin(self, nums: list[int]) -> int:
        start = 0
        n = len(nums)
        end = n - 1
        if start == end:
            return nums[start]
        if nums[start] <= nums[end]:
            return nums[start]

        while start <= end:
            mid = start + (end - start) //2
            nxt = (mid + 1) % n
            prev = (mid + n - 1) % n
            if nums[mid] <= nums[prev] and nums[mid] <= nums[nxt]:
                return nums[mid]
            elif nums[0] <= nums[mid]:
                start = mid + 1
            elif nums[mid] <= nums[end]:
                end = mid - 1
        return -1
        