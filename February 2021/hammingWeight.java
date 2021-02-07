public class Solution {
    // To count the number of one bits we create a masked value that carries a 1 which will be anded 
    // To see if a 1 is at that current point and after that we shift the bit to the right and keep going until 
    // All 32 bits are checked
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
    int bits = 0;
    int mask = 1;
    for (int i = 0; i < 32; i++) {
        if ((n & mask) != 0) {
            bits++;
        }
        mask <<= 1;
    }
    return bits;
    }
}
