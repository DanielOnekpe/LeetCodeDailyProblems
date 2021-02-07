/**
 *  Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
    The number of elements initialized in nums1 and nums2 are m and n respectively. 
    You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.

    [1,2,3,0,0,0] [2,5,6] The way we are going to sort this by checking the last values so num1-3,num2-6 
    Algorithm:
    1. We are going to use the two pointer one pointer for the end of the first array and another for the end of the second array
    2. If the nums1[pointer1] < nums2[pointer2] then the value at the end of the nums1[index] = nums2[pointer2]
    3. If the pointer1 < 0 then the value at the end of the nums1[index] = nums2[pointer2]
    4. If the pointer2 < 0 then we break the loop
    5. If the nums1[pointer1] > nums2[pointer2] then the value at the end of the nums1[index] = nums1[pointer1]

    Time Complexity : O(n)
    Space Complexity : O(1)
 */

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // length of the total array
        int total = nums1.length - 1;
        // pointer for the first array
        int left = m - 1;
        // pointer for the second array
        int right = n - 1;
        
        for(int i = total; i >= 0; i--)
        {
            // if there are no elements in the second array since the first array is sorted then we break cause theres nothing left to do
            if(right < 0)
            {
                break;
            }

            // first we check if there are any elements in the first array or if nums1[pointer1] < nums2[pointer2] we do this
            if(left < 0 || (right >= 0 && nums2[right] > nums1[left]))
            {
                nums1[i] = nums2[right];
                right--;
            }
    
            else
            {
                nums1[i] = nums1[left];
                left--;
            }
        }
   }
}