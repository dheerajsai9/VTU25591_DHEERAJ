class Solution {
    public int numSteps(String s) {
        int steps = 0;
        int carry = 0;
        
        // process from right to left, stop before the most significant bit
        for (int i = s.length() - 1; i > 0; i--) {
            int bit = (s.charAt(i) - '0') + carry;
            
            if (bit % 2 == 0) {
                // even -> divide by 2
                steps += 1;
            } else {
                // odd -> add 1 (causes carry), then divide by 2
                steps += 2;
                carry = 1;
            }
        }
        
        // If carry remains at the MSB, it takes one extra step
        return steps + carry;
    }
}