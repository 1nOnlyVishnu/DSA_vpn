class Solution {
    public int bitwiseComplement(int n) {
        
        //1. use the given input and convert it into it's binary format
        //2. Flip the 1 into 0 and 0 inot 1 
        //3. convert the 2nd step binary num into decimal number and return it.

        String binary = Integer.toBinaryString(n);

        String flipped = ""; 

        for(char ch : binary.toCharArray()){
            if(ch == '0'){
                flipped += "1";
            }else{
                flipped += "0";
            }
        }

        return Integer.parseInt(flipped,2);
    }
}