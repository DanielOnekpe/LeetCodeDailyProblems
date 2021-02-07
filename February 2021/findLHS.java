/**In this approach, we make use of a hashmap mapmap which stores the number of times 
 * an element occurs in the array along with the element's value in the form (num, count of num), 
 * where num refers to an element in the array and count of num 
 * refers to the number of times this num occurs in the nums array. We traverse over the nums array 
 * and fill this mapmap once.
 * After this, we traverse over the keys of the map created. For every key of the map considered, 
 * say key, we find out if the map contains the key + 1. Such an element is found, since only such elements 
 * can be counted for the harmonic subsequence if key is considered as one of the element of the harmonic subsequence. 
 * We need not care about key−1, because if key is present in the harmonic subsequence, at one time either key + 1
 * or key - 1 only could be included in the harmonic subsequence. The case of key - 1 being in the harmonic subsequence 
 * will automatically be considered, when key - 1 is encountered as the current key. 
 * Now, whenver we find that key + 1 exists in the keys of mapmap, 
 * we determine the count of the current harmonic subsequence as count_{key} + count_{key+1}
 * , where count_i refers to the value corresponding to the key i in mapmap, 
 * which reprents the number of times i occurs in the array nums.
*/ 

import java.util.*;
class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int num : nums)
        {
           count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        int max = 0;

        for(int temp : count.keySet())
        {
            if(count.get(temp+1) != null)
            {
                int sumamount = count.get(temp) + count.get(temp+1);
                max = Math.max(sumamount, max);
            }
        }
        
        return max;
    }
}