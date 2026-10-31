class Solution:
    def countDigits(self, num: int) -> int:
        original_num = num
        count = 0
        while num > 0:
            last_digit = num % 10
            if original_num % last_digit == 0:
                count += 1
            num = num // 10
        
        return count
        