class Solution:
    def numSubarraysWithSum(self, nums: list[int], goal: int) -> int:
        if len(nums) == 0:
            return 0

        windowStart = 0
        windowEnd = 0
        count = 0
        summ = 0
        zeroCount = 0

        while windowEnd < len(nums):
            summ += nums[windowEnd]

            while windowStart < windowEnd and (summ > goal or (nums[windowStart] == 0 and summ == goal)):
                if summ > goal:
                    summ -= nums[windowStart]
                    windowStart += 1
                    zeroCount = 0
                else:
                    windowStart += 1
                    zeroCount += 1

            if summ == goal:
                count += zeroCount + 1

            windowEnd += 1

        return count