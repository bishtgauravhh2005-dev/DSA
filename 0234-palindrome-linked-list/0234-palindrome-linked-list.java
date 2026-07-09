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
    public ListNode reverse(ListNode h){
        ListNode prev = null;
        ListNode c = h;
        while(c!=null){
            ListNode next = c.next;
            c.next = prev;
            prev = c;
            c = next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = reverse(slow.next);
        ListNode newhead = second;
        ListNode first = head;

        while(second!=null){
            if(first.val != second.val){
                reverse(newhead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverse(newhead);
        return true;
    }
}