class Solution:
    def minWindow(self, s: str, t: str) -> str:
        mp = {}

        minlen = float('inf')
        start = 0

        for ch in t:
            mp[ch] = mp.get(ch, 0) + 1

        i = j = 0
        count = len(mp)

        while j < len(s):
            if s[j] in mp:
                mp[s[j]] -= 1

                if mp[s[j]] == 0:
                    count -= 1

            if count == 0:
                while count == 0:
                    if s[i] in mp:
                        mp[s[i]] += 1

                        if mp[s[i]] == 1:
                            count += 1

                            if j - i + 1 < minlen:
                                minlen = j - i + 1
                                start = i

                    i += 1

            j += 1

        if minlen == float('inf'):
            return ""

        return s[start:start + minlen]
        