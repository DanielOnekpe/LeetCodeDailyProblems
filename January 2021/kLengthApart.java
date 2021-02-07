class Solution {
    /*
    *   We basically the integer to hold the pointer to the last one that was seen
    *   It is initially set to Integer.MIN_VALUE so we could know if this is the first one to be found 
    */
    public boolean kLengthApart(int[] nums, int k) {
        int previous = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 1)
            {
                if(previous != Integer.MIN_VALUE && (i - previous - 1) < k)
                {
                    return false;
                }
                previous = i;
            }
        }
        return true;
    }
}