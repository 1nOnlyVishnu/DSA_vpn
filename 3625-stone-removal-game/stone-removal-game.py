class Solution:
    def canAliceWin(self, n: int) -> bool:
        if n == 1:
            return False
        toRemove = 10
        turns = 0
        while n >= toRemove:
            n -= toRemove
            toRemove -= 1
            turns += 1

        return turns % 2 != 0
        