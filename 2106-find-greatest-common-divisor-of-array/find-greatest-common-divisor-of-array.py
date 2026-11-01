import math
class Solution:
    def findGCD(self, nums: list[int]) -> int:
        nums = sorted(nums)
        smol = nums[0]
        large = nums[len(nums) - 1]
        return math.gcd(smol, large)

        