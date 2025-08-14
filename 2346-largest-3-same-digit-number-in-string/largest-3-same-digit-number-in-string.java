class Solution {
    public String largestGoodInteger(String num) {
        String largest = "";
        
        for (int i = 0; i <= num.length() - 3; i++) {
            char c = num.charAt(i);
            if (num.charAt(i+1) == c && num.charAt(i+2) == c) {
                String triple = num.substring(i, i+3);
                if (largest.isEmpty() || triple.compareTo(largest) > 0) {
                    largest = triple;
                }
            }
        }
        
        return largest;
    }
}
