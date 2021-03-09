/*** Definition for a binary tree node.*/
import java.util.*;
public class TreeNode {
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

public class addOneRow {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(root == null) return root;
        Queue<TreeNode> q = new LinkedList<>();
        if(d==1)
        {
            TreeNode left = root;
            TreeNode answer = new TreeNode(v);
            answer.left = root;
            return answer;
        }
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0; i < size; i++)
            {
                TreeNode current = q.poll();
                if(d == 2)
                {
                    TreeNode left = current.left;
                    TreeNode right = current.right;
                    current.left = new TreeNode(v);
                    current.right = new TreeNode(v);
                    current.left.left = left;
                    current.right.right = right;
                }
                
                else
                {
                    if(current.left != null)
                    {
                        q.add(current.left);
                    }
                    
                    if(current.right != null)
                    {
                        q.add(current.right);
                    }
                }
            }
            
            if(d == 1) return root;
            d--;
        }
        
        return root;
    }
}
