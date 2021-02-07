/**
 * Question Explanation:
 * Every element in people[] represents the weight of a passenger people[i]
 * This people have to be rescued by boats. And each both has a weight limit that is entered
 * And the passenger limit is 2. Return the minimum number of boats required to save them
 * 
 * Algorithm:
 * 1. sort the array
 * 1. Find the 2 minimum elements left in the array 
 * 2. If their sum is greater than the limit
 * 3. Then pick only the smallest passenger left
 * 4. When a passenger or two are picked to enter a boat we increase the count
 * 5. Repeat this until no passengers at left
 * 6. Return count
 */

import java.util.*;

class Solved{
    public int numRescueBoats(int[] people, int limit) {
        // sort the array
        Arrays.sort(people);
        // two pointers i and j
        int i = 0, j = people.length - 1;
        int count = 0;
        while(i <= j)
        {
            if(people[i] + people[j] <= limit)
            {
                i++;
                j--;
            }
            
            else
            {
                j--;
            }
            
            count++;
        }

        return count;
    }
}