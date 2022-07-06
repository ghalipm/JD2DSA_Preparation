package CyclicList;

import org.w3c.dom.Node;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached
 * again by continuously following the next pointer. Internally, pos is used to denote the index
 * of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 *
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [3,2,0,-4], pos = 1 // 4 points to 2.
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 * Example 2:
 *
 *
 * Input: head = [1,2], pos = 0 // 2 point to 1.
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
 * Example 3:
 *
 *
 * Input: head = [1], pos = -1 // only one element, no cycle.
 * Output: false
 * Explanation: There is no cycle in the linked list.
 *
 *
 * Constraints:
 *
 * The number of the nodes in the list is in the range [0, 104].
 * -105 <= Node.val <= 105
 * pos is -1 or a valid index in the linked-list.
 *
 * Follow up: Can you solve it using O(1) (i.e. constant) memory?
 */

public class CyclicList1 {

    public static void main(String[] args) {
        int[] arr={3,2,0,-4};
       ListNode node=new ListNode(3);
       node.next=new ListNode(2);
       node.next.next=new ListNode(0);
       node.next.next.next=new ListNode(-4);
       node.next.next.next.next=node.next;


       ListNode circleStart=node;
        for (int i = 0; i < arr.length ; i++) {

            if(circleStart.next==null){
                System.out.println("There is no cycle in the linked list.");
                break;
            }else {

            }

        }


    }

    public static  boolean hasCycle(ListNode head) {
        ListNode current=head;
        System.out.println("head = " + head);

        return true;
    }

}
