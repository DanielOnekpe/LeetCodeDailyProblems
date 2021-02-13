/*
*   To scan a matrix, we can use either DFS or BFS to solve it. However, if we use DFS, we need to go through all possible paths in order to find out which one is the shortest.

If we use BFS, in each step, we need to decide which one would move into bottom right position first.

Comparing the two, we can see BFS make more sense than DFS, and probably easier to implement.
*/

import java.util.*;
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        // check if the first[0][0] and last[n-1][n-1] position are blocked
        // unreachable 
           // unreachable path
    if (grid[0][0] != 0 || grid[n-1][n-1] != 0) return -1;

    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[] {0, 0}); // starting top-left
    int steps = 0;

    while (!queue.isEmpty()) {
        int size = queue.size();
        steps++;
        // breadth scan
        for (int t = 0; t < size; t++) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];

            if (r == n - 1 && c == n - 1) return steps; // reach bottom-right

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int nr = r + i, nc = c + j;
                    if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 0) {
                        queue.offer(new int[] {nr, nc});
                        grid[nr][nc] = -1; // mark as visited
                    }
                }
            }
        }
    }
    return -1;
    }
}
