class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        idx = {}

        left = 0
        result = 0
        for i, char in enumerate(s):
            if char in idx:
                left = max(left, idx[char] + 1)
            
            result = max(result, i - left + 1)
            idx[char] = i
        
        return result
      
# 슬라이딩 윈도우 알고리즘 사용
# 시간 복잡도 O(N) N은 s 문자열의 길이
# 공간 복잡도 O(N) 최악의 경우, 문자열의 모든 문자들이 고유한 값일 수 있기 때문에
