/**
 * [2, 4, 3] + [5, 6, 4] linked list adding in reverse
 * Algorithm:
 * 1. Create a new linked list to hold the answer called sum_list
 * 2. Using a while loop that doesnt stop till one of the list or both is finished
 * 3. The way to add is l1.val + l2.val + mod(carry) = sum -> if its greater than sum = sum % 10 and mod = sum / 10
 * 4. When the loop end we set up a new loop to finish any loops that arent finished
 * 5. If the mod isnt empty we can keep adding the value to the listnode
 * 6. Return the sum_list
 
public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
*/
import java.util.*;
class Solid
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode sum_list = new ListNode(0);
        ListNode current_sum = sum_list;
        int mod = 0;
        int sum = 0;

        while(l1 != null && l2 != null)
        {
            sum = l1.val + l2.val + mod;
            mod = sum / 10;
            sum = sum % 10;
            current_sum.next = new ListNode(sum);
            current_sum = current_sum.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null)
        {
            sum = l1.val + mod;
            mod = sum / 10;
            sum = sum % 10;
            current_sum.next = new ListNode(sum);
            current_sum = current_sum.next;
            l1 = l1.next;
        }

        while(l2 != null)
        {
            sum = l2.val + mod;
            mod = sum / 10;
            sum = sum % 10;
            current_sum.next = new ListNode(sum);
            current_sum = current_sum.next;
            l2 = l2.next;
        }

        if(mod > 0)
        {
            current_sum.next = new ListNode(mod);
            current_sum = current_sum.next;
        }

        return sum_list.next;
    }
}

/**
 * Another way of doing this 
 * public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode num1 = l1, num2 = l2, emptyHead = new ListNode(0); 
        ListNode curr = emptyHead;
        int carry = 0;
        
        while(num1 != null || num2 != null) {
            int firstNum = (num1 != null ? num1.val : 0); (fascinating part the use of the ternary operator this says if the value is null then set the value to 0)
            int secondNum = (num2 != null ? num2.val : 0); 
            int sum = firstNum + secondNum + carry;
            
            curr.next = new ListNode(sum % 10);
            carry = sum / 10;
            
            if (num1 != null) num1 = num1.next;
            if (num2 != null ) num2 = num2.next;
            curr = curr.next;
        }   
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return emptyHead.next;
    }
 * 
 */
