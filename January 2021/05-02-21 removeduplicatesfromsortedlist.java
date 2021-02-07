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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode node = head;
        ListNode prev = null;
        
        while(head != null){ 
            
            // if you find a duplicate 
            if(head.next != null && head.val == head.next.val){
                //keep searching until you cant find one, and then make the head point to that
                while(head.next != null && head.val == head.next.val){
                    head = head.next;
                }
                // if the previous node doesnt exist the unduplicate node found will be used
                if(prev == null){
                    node = head.next;
                }
                //if it isnt then connect the previous node to be the next unduplicate node
                else{
                    prev.next = head.next;
                }
                //then move the head
                head = head.next;
            }
            
            else{
                // if theres no duplicate just keep moving in
                prev = head;
                head = head.next;
            }
        }
        return node;
    }
}
