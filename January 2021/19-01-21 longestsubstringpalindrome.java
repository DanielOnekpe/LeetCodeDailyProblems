class Solution {
    public String longestPalindrome(String s) {
    /*  We are going to use dp to make the program solve using older subproblems
        If the values from table[i][j] is true then its a palindrome else false
        To calculate table[i][j] we check if table[i+1][j-1] = true and str[i] same as str[j] it is true else false
        We have to fill table previously for substring of length = 1 and length =2 because 
as we are finding , if table[i+1][j-1] is true or false , so in case of 
        (i) length == 1 , lets say i=2 , j=2 and i+1,j-1 doesn’t lies between [i , j] 
        (ii) length == 2 ,lets say i=2 , j=3 and i+1,j-1 again doesn’t lies between [i , j].
    */
        // get length of input string
        int n = s.length();
        // table[i][j] = false if str.substring[i...j] is not a palindrome else true
        boolean table[][] = new boolean[n][n];
        
        int maxlength = 1;
        // fill in all the single chars since All substrings of length 1 are palindromes
        for(int i = 0; i < n; i++)
        {
            table[i][i] = true;
        }
        
        //check for substring of length 2
        int start = 0;
        for(int i = 0; i < n - 1; i++)
        {
            if(s.charAt(i) == s.charAt(i+1))
            {
                table[i][i+1] = true;
                start = i;
                maxlength = 2;
            }
        }
        
        //check for lengths greater than 2
        for(int k = 3; k <= n; k++)
        {
            for(int i = 0; i < n - k + 1; i++)
            {
                // Get the ending index of substring from
                // starting index i and length k
                int j = i + k - 1;
                
                // checking for sub-string from ith index to
                // jth index iff str.charAt(i+1) to
                // str.charAt(j-1) is a palindrome
                if(table[i+1][j-1] && s.charAt(i) == s.charAt(j))
                {
                    table[i][j] = true;
                    if(k > maxlength)
                    {
                        start = i;
                        maxlength = k;
                    }
                }
            }
        }
        
        return s.substring(start, start + maxlength);
    }
}