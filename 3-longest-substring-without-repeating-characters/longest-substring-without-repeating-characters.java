class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s.length() == 0 || s == null){
            return 0;
        }

        Map<Character,Integer> charFreqMap = new HashMap<>();

        int windowLeft = 0;
        int longestSubString = 0;

        int n = s.length();

        for(int windowRight = 0;windowRight < n;windowRight++){
            char ch = s.charAt(windowRight);

            charFreqMap.put(ch , charFreqMap.getOrDefault(ch , 0) + 1);

            while(charFreqMap.get(ch) > 1){
                char leftChar = s.charAt(windowLeft);
                charFreqMap.put(leftChar , charFreqMap.get(leftChar) -1);
                windowLeft++;
            }

            longestSubString = Math.max(longestSubString , windowRight - windowLeft +1);

        }

        return longestSubString;

        


        
    }
}