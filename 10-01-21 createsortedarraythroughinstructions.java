/**
 * Given an integer array instructions, you are asked to create a sorted array from the elements in instructions. You start with an empty container nums. For each element from left to right in instructions, insert it into nums. The cost of each insertion is the minimum of the following:

The number of elements currently in nums that are strictly less than instructions[i].
The number of elements currently in nums that are strictly greater than instructions[i].
For example, if inserting element 3 into nums = [1,2,3,5], the cost of insertion is min(2, 1) (elements 1 and 2 are less than 3, element 5 is greater than 3) and nums will become [1,2,3,3,5].

Return the total cost to insert all elements from instructions into nums. Since the answer may be large, return it modulo 109 + 7
 */

class Solver {
    private int[] count;
    private int limit = (int)1e5 + 1;
    private int MOD = (int)1e9 + 7;

    public int createSortedArray(int[] instructions) {
        int totalCost = 0;
        this.count = new int[limit];
        for(int i = 0; i < instructions.length; i++) {
            int smallerNumberCount = getCount(instructions[i] - 1);
            int greaterNumberCount = i - getCount(instructions[i]);
            totalCost = (totalCost + Math.min(smallerNumberCount, greaterNumberCount)) % MOD;
            updateCount(instructions[i]);
        }
        return totalCost;
    }

    private void updateCount(int number) {
        while(number < limit) {
            count[number]++;
            number += number & -number;
        }
    }

    private int getCount(int number) {
        int res = 0;
        while(number > 0) {
            res += count[number];
            number -= number & -number;
        }
        return res;
    }
}
