class Solution {
    public boolean isValid(String s) {

        Stack<Character> st = new Stack<>();

        for(char c: s.toCharArray()){
            if(c == '(')
                st.push(')');
            else if(c == '{')
                st.push('}');
            else if(c == '[')
                st.push(']');
            else if(st.isEmpty() || st.peek() != c)
                return false;
            else
                st.pop();
        }

       return st.isEmpty();
 
    }
}