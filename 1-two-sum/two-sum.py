class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        # x + y =  target
        # nums array 
        # target
        # target ,x
        # y = target - x
        # look for y in nums but not efficient so, store the num (x) part in a DS which has O(1) lookup 
        # key - value
        # num - index
        # O(1) lookup in dictionary

        seen = {}
        for index, num in enumerate(nums):
            y = target - num
            if y in seen:
                return [seen[y] , index]
            
            seen[num] = index

        return []
            
        