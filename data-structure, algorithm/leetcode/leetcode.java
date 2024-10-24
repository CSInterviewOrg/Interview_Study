class LongestSubStringFinder {

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int max = 0;

        Set<Character> uniqueCharacterSet = new HashSet<>();
        while (right < s.length()) {
            if (!uniqueCharacterSet.contains(s.charAt(right))) {
                uniqueCharacterSet.add(s.charAt(right++));
                max = Math.max(max, uniqueCharacterSet.size());
            } else {
                uniqueCharacterSet.remove(s.charAt(left++));
            }
        }

        return max;
    }
}
