class Solution:

    def pair_sum_sorted(self,  nums: list[int], start: int, target: int) -> list[int]:
        left = start
        right = len(nums) - 1
        pairs = []

        while left < right:
            sum = nums[left] + nums[right]

            if sum == target:
                pairs.append([nums[left], nums[right]])
                left += 1

                while left < right and nums[left] == nums[left - 1]:
                    left += 1
            elif sum < target:
                left += 1
            else :
                right -= 1
        return pairs

    def threeSum(self, nums: list[int]) -> list[list[int]]:
        n = len(nums)
        nums.sort()
        triplets = [] 

        for i in range(n):
            if nums[i] > 0:
                break
            
            if i > 0 and nums[i] == nums[i-1]:
                continue

            pairs = self.pair_sum_sorted(nums, i + 1, -nums[i])

            for pair in pairs:
                triplets.append([nums[i]] + pair)

        return triplets

                
        