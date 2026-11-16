class Solution:
    def digitSum(self, s: str, k: int) -> str:
        # groups = []
        while len(s) > k:
            ans = ""
            for i in range(0, len(s) , k):
                group = s[i: i +k]
                total = sum(int(ch) for ch in group)
                ans += str(total)
            s = ans
        return s
            

        
        