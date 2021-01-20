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
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // created a new listnode to put the values of the sorted lists
        ListNode every = new ListNode(0);
        ListNode full = every;
        
        // while none of the lists are null the loop goes on
        while(l1 != null && l2 != null){
            //if the first list has a smaller value than the second list
            //then put the first lists value into the created list
            if(l1.val < l2.val){
                full.next = l1;
                l1 = l1.next;
            }
            //if the second list has an equal or smaller value than the second list
            //then put the second lists value into the created list
            else{
                full.next = l2;
                l2 = l2.next;
            }
            //at the end move onto the node for the list
            full = full.next;
        }
        
        //if the first isnt completely done
        //we put all its values in the list
        while(l1 != null){
            full.next = l1;
            l1 = l1.next;  
            full = full.next;
        }
        
        //if the second isnt completely done
        //we put all its values in the list
        while(l2 != null){
            full.next = l2;
            l2 = l2.next;
            full = full.next;
        }
        
        //since the first node of the full is empty so we use the 
        //next node as that isnt empty 
        return every.next;
    }
}