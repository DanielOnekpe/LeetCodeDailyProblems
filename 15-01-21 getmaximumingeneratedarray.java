/**
 * You are given an integer n. An array nums of length n + 1 is generated in the following way:
 * nums[0] = 0
 * nums[1] = 1
 * nums[2 * i] = nums[i] when 2 <= 2 * i <= n
 * nums[2 * i + 1] = nums[i] + nums[i + 1] when 2 <= 2 * i + 1 <= n
 * 
 * Algorithm 
 * 1. If n less than 2 return n
 * 2. Else generated the array values in arr
 * 3. To generate the array. At i we check if 2*i <= n && 2*i + 1 <= n
 * 4. If thats true we generated ar[2*i] = ar[i]
 * 5. Check the max and see if it ar[2*i] > max
 * 6. Also if 2*i + 1 <= n then ar[(2*i)+1] = ar[i] + ar[i+1] 
 * 7. Check the max and see if it ar[(2*i)+1] > max
 * 8. When the loop finishes, return the max
 */

class Solution{
    public int getMaximumGenerated(int n) {
        // return 0 and 1 cause they are the same
        if(n<2){
            return n;
        }
        
        var arr = new int[n+1];
        arr[0]=0;
        arr[1]=1;
        int i = 1;
        int max = -50;
        while(2*i <= n || (2*i)+1 <= n){
            arr[2*i]=arr[i];
            max = Math.max(max, arr[2*i]);
            if((2*i)+1 <= n){
                arr[(2*i)+1]=arr[i]+arr[i+1];
                max = Math.max(max, arr[(2*i)+1]);
            }
            i++;
        }
        
        return max;
    }
}