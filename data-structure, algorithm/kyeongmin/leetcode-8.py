class Solution:
    def myAtoi(self, s: str) -> int:
        sign = 1
        sign_checked = False
        nums = []

        for char in s.strip():
            if char.isdigit():
                nums.append(char)
            elif (char == "-" or char == "+") and len(nums) == 0 and not sign_checked:
                sign_checked = True
                if char == "-":
                    sign = -1
            else:
                break
        
        result = 0
        if nums:
            result = int(''.join(nums))
        result *= sign
        
        if result < -(2 ** 31):
            result = -(2 ** 31)
        elif result > (2 ** 31) - 1:
            result = (2 ** 31) - 1
    
        return result
    
# 브루트 포스
# 시간 복잡도 O(n)
# 공간 복잡도 O(n)
