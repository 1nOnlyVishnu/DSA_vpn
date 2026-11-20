class Solution:
    def dailyTemperatures(self, temperatures: list[int]) -> list[int]:
        n = len(temperatures)
        v = []  # stores our answers
        s = []  # stack storing (temperature, index)

        for i in range(n - 1, -1, -1):
            # Case 1: Stack is empty
            if len(s) == 0:
                v.append(0)
            # Case 2: Top of stack is strictly greater
            elif len(s) > 0 and s[-1][0] > temperatures[i]:
                v.append(s[-1][1] - i)
            # Case 3: Top of stack is smaller or equal
            elif len(s) > 0 and s[-1][0] <= temperatures[i]:
                while len(s) > 0 and s[-1][0] <= temperatures[i]:
                    s.pop()
                if len(s) == 0:
                    v.append(0)
                else:
                    v.append(s[-1][1] - i)

            # Always push the current (temp, index) onto the stack
            s.append((temperatures[i], i))

        v.reverse()
        return v


        