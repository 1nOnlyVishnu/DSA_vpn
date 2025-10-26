class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> freqMap = new HashMap<>();

        for(int i =0;i<s.length();i++){
            char letter = s.charAt(i);
            freqMap.put(letter,freqMap.getOrDefault(letter,0)+1);
        }

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(freqMap.get(c) == 1){
                return i;
            }
        }
        return -1;
    }
}