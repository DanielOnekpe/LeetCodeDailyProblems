// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        Node current = head;
        //Traverse the original list and clone the nodes as you go and place the cloned copy next to its original node. This new linked list is essentially an interweaving of original and cloned nodes.
        while(current != null)
        {
            Node copy = new Node(current.val);
            Node next = current.next;
            current.next = copy;
            copy.next = next;
            current = next;
        }
        
       // Iterate the list having both the new and old nodes intertwined with each other and use the original nodes’ random pointers to assign references to random pointers for cloned nodes. For eg. If B has a random pointer to A, this means cloned B has a random pointer to cloned A.
        current = head;
        while(current != null)
        {
            // current.random.next = value of current.random in new node
            current.next.random = current.random == null ? null : current.random.next;
            current = current.next.next;
        }
        
        // Unweaving the linked lists
        Node dummy = new Node (0);
        current = dummy;
        Node dummyCopy = new Node(0);
        Node currentCopy = dummyCopy;
        
        boolean copy = false;
        while(head != null)
        {
            if(copy)
            {
                currentCopy.next = head;
                currentCopy = currentCopy.next;
            }
            else
            {
                current.next = head;
                current = current.next;
            }
            
            copy = !copy;
            head = head.next;
        }
        
        current.next = null;
        // return the deep copy
        return dummyCopy.next;
    }
}