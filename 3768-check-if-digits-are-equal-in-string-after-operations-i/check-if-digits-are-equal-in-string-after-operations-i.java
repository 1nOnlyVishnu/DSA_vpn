class Solution {
    public boolean hasSameDigits(String s) {
        // Continue the operation until the string length is 2
        while (s.length() > 2) {
            StringBuilder nextS = new StringBuilder();
            // Iterate through consecutive pairs of digits
            for (int i = 0; i < s.length() - 1; i++) {
                int digit1 = s.charAt(i) - '0'; // Convert char to int
                int digit2 = s.charAt(i + 1) - '0'; // Convert char to int
                int newDigit = (digit1 + digit2) % 10; // Calculate new digit
                nextS.append(newDigit); // Append to the new string
            }
            s = nextS.toString(); // Update s for the next iteration
        }
        // After the loop, s will have exactly two digits
        // Check if these two digits are the same
        return s.charAt(0) == s.charAt(1);
    }
}