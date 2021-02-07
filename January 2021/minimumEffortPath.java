import java.util.*;
class Solution {
    public int minimumEffortPath(int[][] heights) {
        /*
         2 ways to approach this question. Basic Dijkstra's and the Binary search method.
        *dp[y][x] = min(max(dp[ty][tx], abs(h[ty][tx] – h[y][x]))) (x, y) and (tx, ty) are neighbors
        repeat this process for at most rows * cols times.
        if dp does not change after one round which means we found the optimal solution and can break earlier.

        Time complexity: O(n^2*m^2))
        Space complexity: O(nm)
        */
        
        // the lengths of the array
        int m = heights.length;
        int n = heights[0].length;
        
        // 2d array to hold the efforts that will be calculated
        int [][] efforts = new int [m][n];
        // Array method to fill the efforts row with a max value that will be fill with the correct effort
        for(int i = 0; i < m; i++) Arrays.fill(efforts[i], Integer.MAX_VALUE);
        
        //dist, row, col --> int[] -> PriorityQueue or minheap the value to be compared to know which is the a[0] of the two arrays
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        // Put a priority queue to represent the [0][0] field and with an effort 0
        pq.offer(new int[]{0, 0, 0});
        //Represents the directions left, right, top, bottom
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        // while the priority queue is not empty 
        while(!pq.isEmpty())
        {
            // array value to hold the values that havebeen put in the priority queue
            int[] min = pq.poll();
            // dist same as the current minimum effort for [row][col]
            int dist = min[0], row = min[1], col = min[2];
            // if the effort of [row][col] is less than the current dist then theres no need to check it we have to continue
            if(dist > efforts[row][col]) continue;
            // if we reach the final point of the array we return the current minimum effort
            if(row == m-1 && col == n-1) return dist;
            
            //Now loop through the directions and check the effort for the top, left, right, bottom of the current array point
            for(int[] d: dir)
            {
                int newRow = row + d[0];
                int newCol = col + d[1];
                // check if the newRow and newCol values are valid array positions
                if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n)
                {
                    // Calculate the max difference between the two points and the maximum effort of the row and col
                    int newDist = Math.max(dist, Math.abs(heights[newRow][newCol] - heights[row][col]));
                    // if the new maximum absolute difference is < than the minimum effort 
                    if(newDist < efforts[newRow][newCol])
                    {
                        // then the minimum effort of the point should be changed to the newdist
                        efforts[newRow][newCol] = newDist;
                        // then the add the newRow and newCol and its effort in the priority queue 
                        pq.offer(new int[]{newDist, newRow, newCol});
                    }
                }
            }
        }
        
        return 0;
    }
}
