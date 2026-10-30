class Solution:
    def findNumbers(self, nums: list[int]) -> int:
        nums = [str(x) for x in nums]
        even_count = 0

        for char in nums:
            digits = len(char)
            if digits % 2 == 0:
                even_count += 1

        return even_count

        