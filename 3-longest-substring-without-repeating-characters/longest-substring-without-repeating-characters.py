class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        arr = list(s)
        if len(arr) == 1: 
            return 1

        if len(arr) == 0:
            return 0

        seen_chars = set()
        left = 0
        max_length = 0

        for right in range(len(arr)):
            current_char = arr[right]

            while current_char in seen_chars:
                seen_chars.remove(arr[left])
                left = left + 1
            
            seen_chars.add(current_char)

        
            max_length = max(max_length , right - left + 1)

        return max_length
        