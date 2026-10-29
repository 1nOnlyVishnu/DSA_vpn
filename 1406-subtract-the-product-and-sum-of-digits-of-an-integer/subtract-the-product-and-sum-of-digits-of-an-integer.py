class Solution:
    def subtractProductAndSum(self, n: int) -> int:
        # 234
        # 4
        # 230 
        # 
        product = 1
        sum_of_digits = 0
        while (n > 0): #234
            last_digit = n % 10 # 4
            n = n // 10 # 23
            product = product * last_digit
            sum_of_digits = sum_of_digits + last_digit

        
        return product - sum_of_digits
            
