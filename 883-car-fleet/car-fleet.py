class Solution:
    def carFleet(self, target: int, position: list[int], speed: list[int]) -> int:
        cars = sorted(zip(position, speed))
        times = [(target - p)/s for p, s in cars]
        stack = []
        fleets = 0

        for i in range(len(times) - 1, -1, -1):
            while len(stack) > 0 and stack[-1] < times[i]:
                stack.pop()
            if len(stack) == 0:
                fleets += 1
            stack.append(times[i])
            
        return fleets