class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {

       boolean[] mp = new boolean[26];
       
       for(char ch : brokenLetters.toCharArray()){
        mp[ch-'a'] = true; 
       }

       int result = 0;

       boolean canType = true;

       for(char ch : text.toCharArray()){
        if(ch == ' '){
            if(canType){
                result++;
            }

            canType = true;
        }else if(mp[ch - 'a']== true){
            canType = false;
        }
       }

       if(canType){
        result++;
       }

       return result;
    }
}