import javax.lang.model.util.ElementScanner14;

/**
 * You are given an array nums, and an integer x
 * One operation is remove the leftmost or rightmost element from the array nums and subtract its value from x
 * Return the minimum number of operations to reduce x to exactly 0
 * If its not possible return -1
 * 
 * Dynamic Programming -> Top Down Approach
 * Algorithm:
 * Always have two options -> either select left end element or right end element
 * We are going to use recursion to solve it. If the x value is less than one we return -1 
 * Find no of steps by first getting the min from the left and the min from the right
 * We return the min(left, right)
 * Left = solve(nums, x-nums[L], L+1, R, count+1)
 * Right = solve(nums, x-nums[R], L, R-1, count + 1)
 * Return min(left, right)
 * 
 * Time: Exponential (2^n)
 * 
 */

public class Solver{
    private HashMap<String, Integer> memo;
    public int minOperations(int[] nums, int x){
        int ans = solve(nums, x, 0, nums.length-1, 0);
        return ans >= (int)1e5 ? -1: ans;
    }

    public int solve(int[] nums, int x, int left, int right, int count){
        if(x == 0) //sum found
        {
            return count;
        }

        if(x < 0 || left < right) //out of bounds
        {
            return (int) 1e5;
        }
        /*
        String key = left + "*" + right + "*" + x;
        if(mem.count(key))
        {
            return mem[key];
        }*/

        int left = solve(nums, x-nums[l], left+1, right, count + 1);
        int right = solve(nums, x-nums[r], left, right-1, count+1);
        return Math.min(left, right);
    }
}