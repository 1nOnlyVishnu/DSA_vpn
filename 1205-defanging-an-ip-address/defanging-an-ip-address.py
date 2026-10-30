class Solution:
    def defangIPaddr(self, address: str) -> str:
        result = []
        for char in address:
            if char != ".":
                result.append(char)
            elif char == ".":
                result.append("[.]")
        
        return "".join(result)

            
        