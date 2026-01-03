class Solution {
    public int characterReplacement(String s, int k) {
        if(s == null || s.length() == 0){
            return 0;
        }

        if(s.length() == 1){
            return 1;
        }

        int start = 0;
        int maxLength = 0;
        int maxRepeatLetterCount = 0;
        HashMap<Character,Integer> freqMap = new HashMap<>();

        for(int end = 0;end < s.length();end++){
            char rightChar = s.charAt(end);
            freqMap.put(rightChar,freqMap.getOrDefault(rightChar,0)+1);

            maxRepeatLetterCount = Math.max(maxRepeatLetterCount,freqMap.get(rightChar));


            if(end - start + 1 - maxRepeatLetterCount > k){
                char leftChar = s.charAt(start);

                freqMap.put(leftChar,freqMap.get(leftChar) - 1);
                start++;

            }
            maxLength = Math.max(maxLength , end - start +1);
            
        }

        return maxLength;
    }
}