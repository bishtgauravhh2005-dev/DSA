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
      ListNode dummy = new ListNode(0);
      dummy.next = head;
      ListNode prev = dummy;
      ListNode curr = head;
      for(int i=0 ;i<left-1;i++){
        curr = curr.next ;
        prev = prev.next;
      }

    
      ListNode start = curr;
      ListNode pre = null;
      for(int i =0 ;i< right -left +1; i++){
        ListNode next = curr.next;
        curr.next = pre;
        pre = curr;
        curr = next;
      }

      prev.next = pre;
      start.next = curr;

    return dummy.next;
    }
}