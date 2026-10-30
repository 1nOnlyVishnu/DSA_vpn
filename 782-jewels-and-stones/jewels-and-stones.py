class Solution:
    def numJewelsInStones(self, jewels: str, stones: str) -> int:
        i = 0
        j = 0
        count = 0
        for i in jewels:
            for j in stones:
                if i == j:
                    count += 1

        return count
