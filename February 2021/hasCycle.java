import java.util.*;
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> existed = new HashSet<>();
        while(head != null)
        {
            if(existed.contains(head))
            {
                return true;
            }
            
            existed.add(head);
            head = head.next;
        }
        
        return false;
    }
}