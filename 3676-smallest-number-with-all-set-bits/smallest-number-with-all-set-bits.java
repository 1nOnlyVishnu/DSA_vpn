class Solution {
    public int smallestNumber(int n) {
        // bitLength = number of bits needed to represent n (without leading zeros)
        int bitLength = Integer.SIZE - Integer.numberOfLeadingZeros(n);
        // The smallest number with bitLength bits all set is (1 << bitLength) - 1
        return (1 << bitLength) - 1;
    }
}
