/**
 * Problem: https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/581/week-3-january-15th-january-21st/3611/
 * Algorithm: 
 * 1. We are meant to find the least subsequence with a length of k
 * 2. What we do is create an array of length k
 * 3. At first we find an empty array and put that first element in the array
 * 4. We keep searching until we fill the array or we find an element that is less than the last element in the array
 *  and enough space behind to hold as many elements are left
 * 5. When we done with the loop we return the complete array
 */
class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int [k];
        int c = 0;
        for(int i = 0; i < n; i++)
        {
            while((c > 0) && (ans[c-1] > nums[i]) && (c + n - i - 1 >= k))
            {
                --c;
            }
            
            if(c < k)
            {
                ans[c++] = nums[i];
            }
        }
        
        return ans;
    }
}