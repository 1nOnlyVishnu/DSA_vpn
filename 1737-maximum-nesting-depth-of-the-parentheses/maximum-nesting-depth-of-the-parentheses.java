class Solution {
    public int maxDepth(String s) {
        int balance = 0;
        int maxDepth = 0;

        for(char ch : s.toCharArray()){
            if(ch == '('){
                balance++;
                maxDepth = Math.max(maxDepth,balance);
            }else if(ch == ')'){
                balance--;
            }
        }

        return maxDepth;
    }
}