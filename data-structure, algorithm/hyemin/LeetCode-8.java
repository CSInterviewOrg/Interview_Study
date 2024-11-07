public int myAtoi(String s) {
        // 문제의 단계 순으로 나눠서 처리하는 로직으로 구현 
        // 시간 복잡도 O(n) : 전체 문자열을 한번만 순차 탐색 
        // 공간 복잡도 O(1) : 리턴값이 int 정수현 변수로 고정된 크기이므로 상수O(1)

        int index = 0; 
        int sign = 1;
        int result = 0;
        int len = s.length();

        while(index < len && s.charAt(index) == ' '){
            index++;
        }

        if(index < len && (s.charAt(index) == '-' || s.charAt(index) == '+')){
            sign = (s.charAt(index) == '-') ? -1 : 1;
            index++;
        }

        while (index < len && String.valueOf(s.charAt(index)).matches("[0-9]")) {
            int digit = Integer.parseInt(String.valueOf(s.charAt(index)));

            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            index++;
        }

        return result * sign;
}
