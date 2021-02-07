/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/*
* In the merging of two lists: All the elements in the list array were added to a priority queue so that the 
* the elements are then sorted. After that we basically removed each element from the queue to make a linked list 
* Which is basically the sorted version of the k lists
*/
import java.util.*;
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> container = new PriorityQueue();
        // put elements in queue
        for(ListNode head: lists)
        {
            while(head != null)
            {
                container.add(head.val);
                head = head.next;
            }
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        
        // remove elements from queue and add them all into the new list
        while(!container.isEmpty())
        {
            int element = container.remove();
            head.next = new ListNode(element);
            head = head.next;
        }
        
        return dummy.next;
    }
}
