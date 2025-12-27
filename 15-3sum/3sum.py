class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        triplets = []

        for i in range(len(nums) - 2):

            if nums[i] > 0:
                break

            if i > 0 and nums[i] == nums[i - 1]:
                continue

            pairs = self.pair_sum_sorted_all_pairs(nums, i + 1, -nums[i])

            for pair in pairs:
                triplets.append([nums[i]] + pair)

        return triplets


    def pair_sum_sorted_all_pairs(self, nums: List[int], start: int, target: int) -> List[List[int]]:
        pairs = []
        left, right = start, len(nums) - 1

        while left < right:
            curr = nums[left] + nums[right]

            if curr == target:
                pairs.append([nums[left], nums[right]])
                left += 1
                right -= 1

                while left < right and nums[left] == nums[left - 1]:
                    left += 1
                while left < right and nums[right] == nums[right + 1]:
                    right -= 1

            elif curr < target:
                left += 1
            else:
                right -= 1

        return pairs
