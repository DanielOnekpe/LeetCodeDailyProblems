class Solution {
    public int lengthOfLongestSubstring(String s) {
        // This is a sliding window problem
        // Basically means working with two pointers :  We basically keep the first pointer and the second pointer moves but when we find a repeat character we shift the window based on the characters point in the substring
        
        int first_pointer = 0; //sits at the first character of the substring
        int second_pointer = 0; // sits at the end of the window
        int max = 0;
        
        HashSet<Character> hash_set = new HashSet<>();
        
        while(second_pointer < s.length()){
            // if a certain character in the substring has never been seen before
            if(!hash_set.contains(s.charAt(second_pointer)))
            {
                // add it to the hashset
                hash_set.add(s.charAt(second_pointer));
                // when you add that in the window by incrementing the pointer so you can check if the next character is part of the longest substring 
                second_pointer++;
                // hash set contains the current distinct character therefore this is the length of the current substring so we check which is bigger between that and the max length we have currently found
                max = Math.max(hash_set.size(), max);
            }
            
            // if a character already exists in the substring or has been seen before
            else
            {   
                // we remove the first character in the substring cause its not longer the longest
                hash_set.remove(s.charAt(first_pointer));
                // and move the first pointer upwards
                first_pointer++;
            }
        }
        
        return max;
    }
}