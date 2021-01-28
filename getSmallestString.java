class Solution {
    /*
    * For this we get a string and try to make a string of length n and have a total equal char - 'a' values as k
    * So the best way to do that is to create a char array to hold the characters that will become part of the string 
    * If the value of k - the number of spaces left is less than 26 then the best character to put in the array 
    * is value of k - the number of spaces left
    * else its z
    */
    public String getSmallestString(int n, int k) {
        char c [] = new char [n];
        for(int i = n - 1; i >= 0; i--)
        {
            int val = Math.min(26, k - i);
            c[i] = (char)('a' + val - 1);
            k = k - val;
        }
        return new String(c);
    }
}