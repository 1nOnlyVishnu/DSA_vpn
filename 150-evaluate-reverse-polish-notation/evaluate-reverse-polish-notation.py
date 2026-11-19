class Solution:
    def evalRPN(self, tokens: list[str]) -> int:
        stack = []
        operation = {
            "+" : lambda a,b: a + b,
            "-" : lambda a,b: a - b,
            "*" : lambda a,b: a * b,
            "/" : lambda a,b: a / b
        }
        for token in tokens:
            if token not in operation:
                token = int(token)
                stack.append(token)
            else:
                # if len(stack) == 0:
                    # break
                if len(stack) != 0:
                    num2 = stack.pop()
                    num1 = stack.pop()
                    print("token:", token)
                    print("operation keys:", operation.keys())
                    result = operation[token](num1,num2)
                    stack.append(int(result))
        return stack[0]


        