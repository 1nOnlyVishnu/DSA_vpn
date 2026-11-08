class Solution:
    def twoSum(self, numbers: list[int], target: int) -> list[int]:
        i = 0
        j = len(numbers) - 1
        while i < j:
            summ = numbers[i] + numbers[j]
            if summ < target:
                i += 1
            elif summ > target:
                j -= 1
            else:
                return [i + 1, j + 1]
        return []
        