import java.util.*;
class Solodolo {
    public boolean closeStrings(String word1, String word2) {
    /*
    *   Find if two strings are close. According to the question two strings are close if they are
    *   1. They have the same set of characters (Hashset) 
    *   2. They have the same sorted counts of characters (Arrays.sort && Arrays.equals)
    */
        
        int[] counter1 = new int [26];
        int[] counter2 = new int [26];
        Set<Character> set1 = new HashSet();
        Set<Character> set2= new HashSet();
        
        // keep track of count of each character and the unique characters in the string
        for(char c: word1.toCharArray())
        {
            counter1[c-'a']++;
            set1.add(c);
        }
        
        for(char c: word2.toCharArray())
        {
            counter2[c-'a']++;
            set2.add(c);
        }
        
        Arrays.sort(counter1);
        Arrays.sort(counter2);
        return set1.equals(set2) && Arrays.equals(counter1, counter2);
    }
}