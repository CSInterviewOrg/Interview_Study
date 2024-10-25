class LongestPalindromicSubstring {
        public String longestPalindrome(String s) {
            int inputLength = s.length();
            String result = "";

            // 가장 긴 회문을 찾기 위해 브루트 포스 진행
            for (int index = 0; index < inputLength; index++) {
                for (int j = index; j < inputLength; j++) {
                    String substring = s.substring(index, j + 1);

                    // 현재 회문 길이보다 새로 찾은 회문의 길이가 큰 경우 큰 회문으로 업데이트
                    if (isPalindromic(substring) && (substring.length() > result.length())) {
                        result = substring;
                    }
                }
            }

            return result;
        }

        // 회문 검사 - 시간복잡도를 줄이기 위해서 투 포인터 이용
        private boolean isPalindromic(String str) {
            int left = 0;
            int right = str.length() - 1;

            while (left < right) {
                if (str.charAt(left) != str.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }

            return true;
        }
    }
