class Solution {
    public boolean wordPattern(String p, String s) {
        String[] delims = s.split(" ");

        if(p.length() != delims.length){
            return false;
        }

        HashMap<Character, String> map = new HashMap<>();

        for ( int i = 0; i < p.length(); i++){
            if(map.containsKey(p.charAt(i))){
                if(!map.get(p.charAt(i)).equals(delims[i])){
                    return false;
                }
            }else{
                if(map.containsValue(delims[i])){
                    return false;
                }
                map.put(p.charAt(i) , delims[i]);
            }
        }
        return true;
    }
}