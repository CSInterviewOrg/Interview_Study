public int maxArea(int[] height) {
    int left = 0;               // 시작 포인터
    int right = height.length - 1;  // 끝 포인터
    int maxArea = 0;            // 최대 물의 양
        
    // 두 포인터가 교차할 때까지 반복
    while (left < right) {
        // 현재 두 선 사이에 담길 수 있는 물의 양 계산
        int currentArea = Math.min(height[left], height[right]) * (right - left);
        // 최대 물의 양 갱신
        maxArea = Math.max(maxArea, currentArea);
            
        // 더 작은 선을 이동
        if (height[left] < height[right]) {
            left++;  // 왼쪽 선이 더 작으면 왼쪽 포인터를 오른쪽으로 이동
        } else {
            right--; // 오른쪽 선이 더 작으면 오른쪽 포인터를 왼쪽으로 이동
        }
    }
        
   return maxArea;
}
