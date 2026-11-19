class Solution:
    def generateParenthesis(self, n: int) -> list[str]:
        stack = []
        res = []

        def backtrack(openN,close):
            if openN == close == n:
                res.append("".join(stack))
                return 
            
            if openN < n:
                stack.append("(")
                backtrack(openN + 1, close)
                stack.pop()
            
            if close < openN:
                stack.append(")")
                backtrack(openN, close + 1)
                stack.pop()
        
        backtrack(0,0)
        return res


        