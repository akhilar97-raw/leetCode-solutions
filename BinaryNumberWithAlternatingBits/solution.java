class Solution {
    /**
     * Checks if a positive integer has alternating bits.
     * A number has alternating bits if adjacent bits are always different.
     * For example: 5 (binary: 101) has alternating bits, 7 (binary: 111) does not.
     * 
     * @param n The positive integer to check
     * @return true if n has alternating bits, false otherwise
     */
    public boolean hasAlternatingBits(int n) {
        int previousBit = -1;
    
        while (n != 0) {
            int currentBit = n & 1;
        
            if (previousBit == currentBit) {
                return false;
            }
            previousBit = currentBit;

            n >>= 1;
        }
        return true;
    }
}