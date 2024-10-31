class Solution {
    public String convert(String s, int numRows) {
        
      // 예외 처리: 행이 1이거나 문자열 길이가 행보다 작으면 그대로 반환
        if (numRows == 1 || s.length() <= numRows) return s;

        // 각 행에 대한 StringBuilder 생성
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        // 방향과 현재 행 초기화
        int currentRow = 0;
        boolean goingDown = false;

        // 각 문자를 지그재그 순서로 행에 추가
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);
            // 맨 위 또는 맨 아래 행에 도달하면 방향 전환
            if (currentRow == 0 || currentRow == numRows - 1) goingDown = !goingDown;
            // 방향에 따라 행 이동
            currentRow += goingDown ? 1 : -1;
        }

        // 모든 행을 합쳐 최종 문자열 생성
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();

    }
}
