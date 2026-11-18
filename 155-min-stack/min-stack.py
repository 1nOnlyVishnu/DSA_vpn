class MinStack:

    def __init__(self):
        self.stack = []
        self.minEle = float("inf")
        

    def push(self, val: int) -> None:
        if len(self.stack) == 0:
            self.stack.append(val)
            self.minEle = val
        else:
            if val >= self.minEle:
                self.stack.append(val)
            elif val < self.minEle:
                self.stack.append((2 * val) - self.minEle)
                self.minEle = val
        # self.stack.append(val)
        # # value = min(value, self.minStack[-1] if self.minStack else value)
        # if not self.minStack or val <= self.minStack[-1]:
        #     self.minStack.append(val)
        # else:
        #     self.minStack.append(self.minStack[-1])
        # # self.minStack.append(value)
    

    def pop(self) -> None:
        if len(self.stack) == 0:
            return
        else:
            if self.stack[-1] >= self.minEle:
                self.stack.pop()
            elif self.stack[-1] < self.minEle:
                self.minEle = (2 * self.minEle) - self.stack[-1]
                self.stack.pop()


    def top(self) -> int:
        if len(self.stack) == 0:
            return -1
        else:
            if self.stack[-1] >= self.minEle:
                return self.stack[-1]
            elif self.stack[-1] < self.minEle:
                return self.minEle
        
        
    def getMin(self) -> int:
        # if self.len(supportingStack) == 0:
        #     return -1
        if len(self.stack) == 0 or self.minEle == float(inf):
            return -1
        return self.minEle  


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(value)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()