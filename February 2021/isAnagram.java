/*
*   To check if two strings are an anagram. We could find so by creating an array that goes through
*   holds the occurence of character in each string. We go through the first string and then make 
*   a count of the number of occurence of each character in the string in the array. Then we loop 
*   through the second string and then subtract each occurence of every character in the string in 
*   the array and then through the array we check the count of every index and then make sure its 
*   zero if its not zero then the occurences of the character in the first string and the second
*   string are not equal therefore it cannot be an anagram
*/

class Solution {
    public boolean isAnagram(String s, String t) {
        // to hold the count of every character in each string
        int[] map = new int [26];
    
        for(char c : s.toCharArray())
        {
            // find a position for the character
            int pos = c -'a';
            // increase its count
            map[pos]++;
        }
        
        for(char c: t.toCharArray())
        {
            // find a position for the character
            int pos = c - 'a';
            // reduce its count
            map[pos]--;
        }
        
        for(int i : map)
        {
            // return false because the count of(char i) in s and t is not equal
            if(i != 0) return false;
        }
        
        return true;
    }
}