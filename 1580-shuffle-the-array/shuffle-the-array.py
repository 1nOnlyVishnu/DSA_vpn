class Solution:
    def shuffle(self, nums: List[int], n: int) -> List[int]:
        result = [0] * len(nums)
        i = 0
        j = n
        index = 0
        while ( i < n):
            result[index] = nums[i]
            index += 1
            i += 1
            result[index] = nums[j]
            index += 1
            j += 1
        
        return result


        
        