class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hash_map = {}
        # x + y = target
        # y = target - x
        for index, num in enumerate(nums):
            y = target - num
            if y in hash_map:
                return [hash_map[y] , index]
            hash_map[num] = index
        
        return []


        