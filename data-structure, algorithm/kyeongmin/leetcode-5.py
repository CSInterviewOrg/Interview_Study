class Solution:
    def longestPalindrome(self, s: str) -> str:
        def check(left, right):
            while left >= 0 and right < len(s) and s[left] == s[right]:
                left -= 1
                right += 1
            
            return right - left - 1
        

        start = 0
        end = 0
        for i in range(len(s)):
            odd = check(i, i)
            even = check(i, i + 1)

            length = max(odd, even)

            if length > end - start:
                start = i - (length - 1) // 2
                end = i + length // 2
        
        return s[start: end + 1]

# 투포인터 알고리즘 사용
# 시간 복잡도 O(n^2)   최악의 경우, 문자열 양끝까지 확인 필요
# 공간 복잡도 O(1)    상수 값만 저장
