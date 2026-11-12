class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2):
            return False
         
        s1Map = [0] * 26
        s2Map = [0] * 26

        for i in range(len(s1)):
            s1Map[ord(s1[i]) - ord('a')] += 1
            s2Map[ord(s2[i]) - ord('a')] += 1

        n = len(s2) - len(s1)

        for i in range(n):
            if self.matches(s1Map, s2Map):
                return True
            s2Map[ord(s2[i + len(s1)]) - ord('a')] += 1
            s2Map[ord(s2[i]) - ord('a')] -= 1
        
        return self.matches(s1Map,s2Map)
    
    def matches(self, s1Map: list, s2Map: list) -> bool:
        for i in range(26):
            if s1Map[i] != s2Map[i]:
                return False

        return True




        