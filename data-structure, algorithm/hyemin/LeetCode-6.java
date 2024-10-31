class LeetCode6{

   // 시간복잡도 O(n) 
   // 공간복잡도 O(n) 

  public String convert(String s, int numRows) {
        if(numRows == 1 || numRows >= s.length()) return s;

        StringBuilder result = new StringBuilder();
        int cycle = 2 * (numRows - 1);

        for(int i = 0; i < numRows; i++){
            for(int j = i; j < s.length(); j+=cycle){
                result.append(s.charAt(j));
                if(i > 0 && i < numRows -1 && ( j + cycle - 2 * i ) < s.length()){
                    result.append(s.charAt( j + cycle - 2 * i ));
                }
            }
        }
        return new String(result);
    }
}
