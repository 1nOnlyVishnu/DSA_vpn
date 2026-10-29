class Solution:
    def numberOfSteps(self, num: int) -> int:
        count_steps = 0
        while num > 0: # t, t, t
            if num % 2 == 0: # t, t, t
                count_steps += 1 # 1, 2, 3
                num = num // 2 # 4, 2 , 1
            elif num % 2 != 0:
                num = num - 1 # 0
                count_steps += 1

        return count_steps
        