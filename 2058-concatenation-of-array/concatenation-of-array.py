class Solution:
    def getConcatenation(self, nums: list[int]) -> list[int]:
        ans = [0] * (2 * len(nums))
        index = 0
        for num in nums:
            ans[index] = num
            index += 1
        
        for num in nums:
            ans[index] = num
            index += 1
        
        return ans
        