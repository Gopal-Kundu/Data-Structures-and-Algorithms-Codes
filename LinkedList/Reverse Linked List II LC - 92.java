//https://leetcode.com/problems/reverse-linked-list-ii/

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode beforeLeftNode = dummy; //Prev node of left
        for (int i = 0; i < left - 1; i++) {
            beforeLeftNode = beforeLeftNode.next;
        }

        ListNode holdLeft = beforeLeftNode.next; //Current left node. 
        ListNode currNode = holdLeft;
        ListNode prev = null;
        for (int i = 0; i < right - left + 1; i++) {
            ListNode nextNode = currNode.next;
            currNode.next = prev; // Points to prev node
            prev = currNode;
            currNode = nextNode;
        }

        beforeLeftNode.next = prev;
        holdLeft.next = currNode;

        return dummy.next;

    }
}