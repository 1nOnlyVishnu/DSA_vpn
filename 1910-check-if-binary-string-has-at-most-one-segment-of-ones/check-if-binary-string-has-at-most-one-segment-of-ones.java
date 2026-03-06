class Solution {
    public boolean checkOnesSegment(String s) {
        boolean seenZeroAfterOne = false;

        for (char c : s.toCharArray()) {
            
            if (c == '0') {
                if (seenZeroAfterOne == false && s.contains("1")) {
                    seenZeroAfterOne = true;
                }
            }

            if (c == '1' && seenZeroAfterOne) {
                return false;
            }
        }

        return true;
    }
}