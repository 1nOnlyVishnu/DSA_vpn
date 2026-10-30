class Solution:
    def maximumWealth(self, accounts: list[list[int]]) -> int:
        max_wealth = 0
        row_sum = 0
        for row in accounts:
            for item in row:
                row_sum += item 
                max_wealth = max(row_sum , max_wealth) 
            row_sum = 0
        return max_wealth
                


        
        