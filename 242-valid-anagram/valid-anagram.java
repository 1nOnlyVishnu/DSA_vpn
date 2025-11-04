class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false;
        HashMap<Character,Integer> freqMap = new HashMap<>();

        for(char ch : s.toCharArray()){
            freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);
        }

        for (char ch : t.toCharArray()) {
            if (!freqMap.containsKey(ch)) {
                return false; // character not in s
            }
            freqMap.put(ch, freqMap.get(ch) - 1);
            if (freqMap.get(ch) < 0) {
                return false; // more occurrences in t than s
            }
        }

       return true;
    }
}