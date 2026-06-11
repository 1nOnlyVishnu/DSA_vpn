class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        return self.count_helper(s) == self.count_helper(t)

    def count_helper(self, s):
        count = {}
        
        for char in s:
            if char not in count:
                count[char] = 0

            count[char] += 1

        return count
        