class Solution:
    def longestConsecutive(self, nums: list[int]) -> int:
        my_set = set()
        for num in nums:
            my_set.add(num)
        longest = 0
        for num in my_set:
            if num-1 not in my_set:
                temp = num
                count = 1
                while temp + 1 in my_set:
                    count += 1
                    temp += 1
                longest = max(longest,count)

        return longest
                

        