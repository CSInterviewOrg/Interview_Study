class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows == 1:
            return s
        
        strings = [[] for _ in range(numRows)]
        direction = True

        now = 0
        for i, char in enumerate(s):
            strings[now].append(char)

            if direction == True:
                now += 1
            else:
                now -= 1

            if now >= numRows:
                direction = False
                now -= 2
            
            if now < 0:
                direction = True
                now += 2
        
        return "".join(["".join(string) for string in strings])

# 시간 복잡도 O(n)
# 공간 복잡도 O(n)
