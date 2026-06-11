class Solution {

    public int maxFreqSum(String s) {
     HashMap<Character,Integer> vowelMap = new HashMap<>();
     HashMap<Character,Integer> consonantMap = new HashMap<>();

     for (char ch : s.toCharArray()){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            vowelMap.put(ch,vowelMap.getOrDefault(ch,0) + 1);
        }else{
            consonantMap.put(ch,consonantMap.getOrDefault(ch,0) + 1);
        }
     }

int maxVowelFreq = 0;
     
for (int freq : vowelMap.values()){
    maxVowelFreq = Math.max(maxVowelFreq,freq);
}

int maxConsonantFreq = 0;

for(int freq : consonantMap.values()){
    maxConsonantFreq = Math.max(maxConsonantFreq,freq);
}

return maxVowelFreq + maxConsonantFreq;
  
    }
}