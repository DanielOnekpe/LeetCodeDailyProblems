class Solution {
    public int[] shortestToChar(String s, char c) {
        int prev = Integer.MAX_VALUE;
        int ar[] = new int[s.length()];

        // Find distance from occurrences of X
        // appearing before current character.
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c)
                prev = i;
            if (prev == Integer.MAX_VALUE)
                ar[i] = Integer.MAX_VALUE;
            else
                ar[i] = (i - prev);
        }

        // Find distance from occurrences of X
        // appearing after current character and
        // compare this distance with earlier.
        prev = Integer.MAX_VALUE;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c)
                prev = i;
            if (prev != Integer.MAX_VALUE)
                ar[i] = Math.min(ar[i], prev - i);
        }
        return ar;
    }
}