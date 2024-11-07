// 1. 문자열이 null 또는 빈 문자열인 경우 바로 0 반환
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int index = 0;
        int length = s.length();
        int sign = 1; // 양수는 1, 음수는 -1
        int result = 0;

        // 2. 공백 문자 건너뛰기
        while (index < length && s.charAt(index) == ' ') {
            index++;
        }

        // 3. 부호 확인
        if (index < length) {
            if (s.charAt(index) == '+') {
                index++;
            } else if (s.charAt(index) == '-') {
                sign = -1;
                index++;
            }
        }

        // 4. 숫자를 읽어들여 정수로 변환
        while (index < length) {
            char currentChar = s.charAt(index);

            // 숫자가 아닌 경우 변환 종료
            if (currentChar < '0' || currentChar > '9') {
                break;
            }

            int digit = currentChar - '0';

            // 5. 오버플로우/언더플로우 방지: Integer.MAX_VALUE = 2147483647, Integer.MIN_VALUE = -2147483648
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            // result를 10 곱하고 현재 숫자 추가
            result = result * 10 + digit;
            index++;
        }

        // 6. 부호 반영
        return result * sign;
    }
