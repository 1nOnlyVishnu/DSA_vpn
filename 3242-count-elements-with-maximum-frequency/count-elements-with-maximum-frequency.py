class Solution:
    def maxFrequencyElements(self, nums: List[int]) -> int:
        freq_map = {}
        for num in nums:
            freq_map[num] = freq_map.get(num, 0) + 1

        max_freq = 0
        for value in freq_map.values():
            max_freq = max(max_freq, value)
        
        total = 0
        for value in freq_map.values():
            if value == max_freq:
                total = total + value
        
        return total

        