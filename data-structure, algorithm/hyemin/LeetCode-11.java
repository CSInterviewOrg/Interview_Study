public int maxArea(int[] height) {
       // 시간 복잡도 : O(n) 배열을 한번 순회 
       // 공간 복잡도 : O(1) 추가적인 메모리 사용없이 상수 공간만 사용 
       
        
        int left = 0;
        int right = height.length -1;
        int maxArea = 0;

        while(left < right ){
            int width = right - left;
            int area = Math.min(height[right], height[left]) * width;
            maxArea = Math.max(maxArea, area);

            if(height[left] < height[right]){
                left++;
            } else {
                right--;
            }

        }

        return maxArea;
}
