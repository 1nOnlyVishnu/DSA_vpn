class Solution:
    def trap(self, height: list[int]) -> int:
        maxL = []
        maxL.append(height[0])
        for i in range(1,len(height)):
            maxL.append(max(maxL[i-1],height[i]))
        
        maxR = [0] * len(height)
        maxR[-1] = height[-1]
        n = len(height) - 1
        for i in range(n - 1,-1,-1):
            maxR[i] = max(height[i],maxR[i+1])
        
        water = []
        for i in range(len(height)):
            water.append(min(maxL[i],maxR[i]) - height[i])

        return sum(water)
        
        