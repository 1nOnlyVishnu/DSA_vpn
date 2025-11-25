class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int k = p.length();
        int j = 0;
        int i = 0;
        List<Integer> ans = new ArrayList<>();

        if (k >  s.length()) return ans;


        Map<Character,Integer> freqMap = new HashMap<>();

        for(char ch: p.toCharArray()){
            freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);
        }

        int count = freqMap.size();



        while(j<s.length()){
            char ch= s.charAt(j);

            if(freqMap.containsKey(ch)){
                freqMap.put(ch,freqMap.get(ch) - 1);
                if(freqMap.get(ch) == 0){
                    count--;
                }
            }

            if(j-i+1 < k){
                j++;
            }
            else if(j-i+1 == k){
                if(count == 0) ans.add(i);

                char leftChar = s.charAt(i);

                if (freqMap.containsKey(leftChar)) {
                    if (freqMap.get(leftChar) == 0) count++;
                    freqMap.put(leftChar, freqMap.get(leftChar) + 1);
                }
                i++;
                j++;
            }
        }

        return ans;
    }
}