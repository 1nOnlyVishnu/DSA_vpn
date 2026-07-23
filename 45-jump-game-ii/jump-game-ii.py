class Solution:
    def jump(self, nums: List[int]) -> int:
        # Initialize variables
        jump_count = 0  # Number of jumps made
        current_jump_end = 0  # The farthest index reachable with current number of jumps
        farthest_reachable = 0  # The farthest index we can reach overall
      
        # Iterate through all elements except the last one
        # We don't need to check the last element since we want to reach it, not jump from it
        for i in range(len(nums) - 1):
            # Update the farthest index we can reach from current position
            farthest_reachable = max(farthest_reachable, i + nums[i])
          
            # If we've reached the end of the current jump's range
            if i == current_jump_end:
                # We must make another jump
                jump_count += 1
                # Update the range of the next jump to the farthest we can reach
                current_jump_end = farthest_reachable
      
        return jump_count