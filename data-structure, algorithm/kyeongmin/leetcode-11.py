class Solution:
    def maxArea(self, height: List[int]) -> int:
        left, right = 0, len(height) - 1

        result = 0
        while left < right:
            now = (right - left) * min(height[left], height[right])
            result = max(result, now)

            if height[left] < height[right]:
                left += 1
            else:
                right -= 1
        
        return result

# 투포인터 알고리즘
# 시간 복잡도 O(n)
# 공간 복잡도 O(1)
