class Solution {
    private HashMap<Character,Integer> freqMap(String str){
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : str.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0 ) + 1);
        }

        return map;
    }

    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> freqMap1 = freqMap(s);
        HashMap<Character,Integer> freqMap2 = freqMap(t);

        return freqMap1.equals(freqMap2);
    }

}