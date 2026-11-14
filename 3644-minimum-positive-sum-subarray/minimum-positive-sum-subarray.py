class Solution:
    def minimumSumSubarray(self, nums: List[int], l: int, r: int) -> int:
        n = len(nums)
        # l is Minimum window size and r is maximum window Size.
        ans = float('inf')
        for window_size in range(l, r + 1): # try every window between l and r
            window_sum = sum(nums[:window_size])
            if window_sum > 0: # check if win_sum is positive 
                ans = min(ans, window_sum)
            for j in range(window_size, n): # slide window
                window_sum += nums[j] # add new element 
                window_sum -= nums[j - window_size] # reomve element leaving the window
                if window_sum > 0:
                    ans = min(ans, window_sum)

        return ans if ans != float('inf') else -1
        