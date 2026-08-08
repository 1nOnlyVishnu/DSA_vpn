class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        """
        target , x , y
        x + y = target
        if i fix x using the data from array,then we only hv to find y
        y = target - x
        input = array (nums) and target
        HashMap { key : value}
        element - index

        """

        map = {}
        for i in range(len(nums)):
            y = target - nums[i]
            if y in map:
                return [map[y] , i]
            map[nums[i]] = i
        
        return []