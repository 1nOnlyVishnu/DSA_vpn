class Solution:
    def longestMonotonicSubarray(self, nums: List[int]) -> int:
        res = 1
        inc = 1
        dec = 1 
        for i in range(1, len(nums)): #[1,4,3,3,2]
            if nums[i] < nums[i-1]:# 2 < 3
                dec += 1
                inc = 1 # 4
            elif nums[i] > nums[i - 1]: # 3 > 4
                inc += 1
                dec = 1
            else:
                inc = 1
                dec = 1
            res = max(res, inc, dec)
        return res
        