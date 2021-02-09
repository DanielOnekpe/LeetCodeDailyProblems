/**
 * Definition for a binary tree node.
 * */
 
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution {
    // to keep track of the running sum
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        // make the greater tree
        makeGreater(root);
        return root;
    }
    
    public void makeGreater (TreeNode root)
    {
        // if empty return nothing
        if(root == null) return;
        // recur on the right subtree
        makeGreater(root.right);
        // add the val of the current node to the sum total
        sum += root.val;
        // change the value of the node to the current great sum
        root.val = sum;
        // recur on the left subtree
        makeGreater(root.left);
    }
}