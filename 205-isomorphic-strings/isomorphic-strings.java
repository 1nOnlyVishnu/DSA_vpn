class Solution {
    public boolean isIsomorphic(String s, String t) {

                    //    01234        01234
        // Input: s = "paper", t = "title"
        // map ={'p':'t' , 'a':'i', ''}


        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++){// i = 2
            if (map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i)) != t.charAt(i)){
                    return false;
                }
            }else{
                if(map.containsValue(t.charAt(i))){
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            }
        }

        return true;
    }
}