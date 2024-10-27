class LongestPalindromicSubstring{
  
   public String longestPalindrome(String s) {
        
        if(s == null || s.length() < 1) return "";

        int start = 0;
        int end = 0;

        for(int i = 0; i < s.length(); i++){
            int odd = calculateRange(s , i , i); // 홀수
            int even = calculateRange(s , i , i +1 ); // 짝수
            int len = Math.max(odd, even);

            if( len > end - start){
                start = i - (len -1)/2;
                end = i + len /2;
            }
        }
        return s.substring(start, end + 1);
    }
    

    private int calculateRange(String s, int left, int right) {
        while( left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }
}
