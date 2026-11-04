class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        # return sorted(s) == sorted(t)
        # take the s string and create a freq map, a:0,n:0,g:0,r:0,m:0
        # traverse the t string, take on char and check in freq map, if it exists, we will decrement its count, 
        if len(s) < len(t):
            return False
        freq_map = {}
        first_str = list(s)
        for c in first_str:
            freq_map[c] = freq_map.get(c, 0) + 1
        
        second_str = list(t)
        for char in second_str:
            if char in freq_map:
                freq_map[char] -= 1

        all_zero = all(count == 0 for count in freq_map.values())
        return all_zero

        