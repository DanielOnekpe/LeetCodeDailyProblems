import java.util.*;
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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        // if the tree is empty we return null to end the recursion
        if(root == null)
        {
            return null;
        }
        
        // we trim the left node
        root.left = trimBST(root.left, low, high);
        // we trim the right node
        root.right = trimBST(root.right, low, high);
        
        // to trim we check if the value is less than low or higher than high
        // if key less than low then we return the right node
        if(root.val < low)
        {
            TreeNode rchild = root.right;
            return rchild;
        }
        // if key higher than high then we return the left node
        if(root.val > high)
        {
            TreeNode lchild = root.left;
            return lchid;
        }
        
        // if nothing wrong then we return the root
        return root;
    }
}
