
class LongestSubstringWithoutRepeatingCharacters{

  public int longestSubstring(String input){
        
        HashMap<Character, Integer> checkMap = new HashMap<>();
        int maxLength = 0;
        int start = 0; 

        for(int end = 0; end < input.length(); end++){
            char currentInput = input.charAt(end);

            if(checkMap.containsKey(currentInput)){
                start = Math.max(start, checkMap.get(currentInput) + 1);
            }
            checkMap.put(currentInput, end);
            maxLength = Math.max(maxLength, end-start+1);

        }
        
        return maxLength;
    }
}
