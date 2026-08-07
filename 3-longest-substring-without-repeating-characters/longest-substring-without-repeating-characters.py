class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        max_len = 0
        left = right = 0
        seen = set()
        while right < len(s):
            while s[right] in seen:
                seen.remove(s[left])
                left += 1
            max_len = max(max_len, right - left + 1)
            seen.add(s[right])
            right += 1

        
        return max_len