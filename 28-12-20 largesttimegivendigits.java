class Solution {
    // This holds the value of the current max time
    private int max_time = -1;

    public String largestTimeFromDigits(int[] A) {
        this.max_time = -1;
        //We are going to loop through all possible combinations of the indices of the array and find the max throught the validate method
        // We skip duplicate elements by removing combinations that have equals indices. 
        // The i4 element doesnt need a loop because if we have the three indices and they are not duplicate then its constant so we could just use the answer in the code
        for (int i1 = 0; i1 < A.length; ++i1)
            for (int i2 = 0; i2 < A.length; ++i2)
                for (int i3 = 0; i3 < A.length; ++i3) {
                    // skip duplicate elements
                    if (i1 == i2 || i2 == i3 || i1 == i3)
                        continue;
                    // the total sum of indices is 0 + 1 + 2 + 3 = 6.
                    int i4 = 6 - i1 - i2 - i3;
                    //holds the current permutation in an array that can be sent to validate time
                    int [] perm = {A[i1], A[i2], A[i3], A[i4]};
                    // check if the permutation can form a time
                    validateTime(perm);
                }
        if (this.max_time == -1)
            return "";
        else
            return String.format("%02d:%02d", max_time / 60, max_time % 60);
    }

    protected void validateTime(int[] perm) {
        //we collect the values of the combination and convert the first two digits to hours and last two digits to minutes
        int hour = perm[0] * 10 + perm[1];
        int minute = perm[2] * 10 + perm[3];
        // if hour is higher than 24 or the minute is higher than 60 its not a valid time
        if (hour < 24 && minute < 60)
            this.max_time = Math.max(this.max_time, hour*60 + minute);
    }
}