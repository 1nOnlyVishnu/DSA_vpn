class Solution:
    def maxLength(self, nums: List[int]) -> int:
        longest = 0
        for windowStart in range(len(nums)):
            for windowEnd in range(windowStart, len(nums)):
                prod = self.product(nums,windowStart, windowEnd)
                gcd = self.gcd(nums, windowStart, windowEnd)
                lcm = self.lcm(nums, windowStart,windowEnd)
                if prod == gcd * lcm:
                    length = windowEnd - windowStart + 1
                    longest = max(longest,length)  

        return longest

    def product(self,nums: List[int],windowStart: int,windowEnd: int)->int:
        prod = 1
        for i in range(windowStart,windowEnd + 1):
            prod *= nums[i]
        return prod
    
    def gcd(self, nums: List[int], windowStart: int, windowEnd: int)-> int:
        gcdNum = 0
        for i in range(windowStart, windowEnd + 1):
           gcdNum = math.gcd(gcdNum, nums[i])
        return gcdNum

    def lcm(self, nums: List[int], windowStart: int, windowEnd: int)-> int:
        lcmNum = 1
        for i in range(windowStart, windowEnd + 1):
           lcmNum = math.lcm(lcmNum, nums[i])
        return lcmNum

