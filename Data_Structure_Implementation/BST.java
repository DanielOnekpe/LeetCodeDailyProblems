import java.util.*;
/**
 * Binary Search Tree is a node based binary tree data structure which has the
 * following properties: The left subtree of a node contains only nodes with
 * keys lesser than the nodes key. The right subtree of a node contains only
 * nodes with keys greater than the nodes key. The left and right subtree each
 * must also be a binary search tree.
 */

// A binary tree node
class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class Index {
    int index = 0;
}

class BinarySearchTree {
    Index index = new Index();

    // A recursive function to construct full from pre[]
    // preIndex is used to keep track of index in pre[]
    Node constructTreeUtil(int pre[], Index preIndex, int low, int high, int size) {
        // Base case
        if (preIndex.index >= size || low > high) {
            return null;
        }

        // The first node in preorder traversal is root. So take the node at preIndex
        // from pre[] and make it root and increment preIndex
        Node root = new Node(pre[preIndex.index]);
        preIndex.index = preIndex.index + 1;

        // If the current subarray has only one element no need to recur
        if (low == high) {
            return root;
        }

        // Search for the first element greater than root
        int i;
        for (i = low; i <= high; ++i) {
            if (pre[i] > root.data) {
                break;
            }
        }

        // Use the index of element found in preorder to divide preorde array in two
        // part left subtree and right subtree
        root.left = constructTreeUtil(pre, preIndex, preIndex.index, i - 1, size);
        root.right = constructTreeUtil(pre, preIndex, i, high, size);

        return root;
    }

    // The main function to construct BST from given preorder traversal. This
    // function mainly uses constructTreeUtil()
    Node constrcutTree(int pre[], int size) {
        return constructTreeUtil(pre, index, 0, size - 1, size);
    }

    // A utility function to print inorder traversal of a Binary tree
    void printInorder(Node node) {
        if (node == null) {
            return;
        }

        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }
}
