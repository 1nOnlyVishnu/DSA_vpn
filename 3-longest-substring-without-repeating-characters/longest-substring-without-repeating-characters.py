class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        mp = {}
        windowStart = 0
        windowEnd = 0
        mx = 0

        while windowEnd < len(s):
            mp[s[windowEnd]] = mp.get(s[windowEnd], 0) + 1

            if len(mp) == (windowEnd - windowStart + 1):
                mx = max(mx, windowEnd - windowStart + 1)
                windowEnd += 1

            elif len(mp) < (windowEnd - windowStart + 1):
                while len(mp) < (windowEnd - windowStart + 1):
                    mp[s[windowStart]] -= 1

                    if mp[s[windowStart]] == 0:
                        del mp[s[windowStart]]

                    windowStart += 1

                mx = max(mx, windowEnd - windowStart + 1)
                windowEnd += 1

        return mx
