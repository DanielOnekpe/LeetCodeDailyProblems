/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> visibleValues = new ArrayList<>();
        // if tree is empty return empty List
        if(root == null) return visibleValues;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        
        while(!nodes.isEmpty())
        {
            // get the number of nodes in the current level
            int size = nodes.size();
            // and loop only for those ones
            for(int i = 0; i < size; i++)
            {
                TreeNode current = nodes.poll();
                // if its the rightmost element on a level add it to the visibleValues 
                if(i == size - 1)
                {
                    visibleValues.add(current.val);
                }
                // add the left and right for the current node for the next level
                if(current.left != null)
                {
                    nodes.add(current.left);
                }
                
                if(current.right != null)
                {
                    nodes.add(current.right);
                }
            }
        }
        
        return visibleValues;
    }
}