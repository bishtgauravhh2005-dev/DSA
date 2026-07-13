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
 // Approach :
 // Check if the node have k size group nodes:
 // recursive call for rest of the part 
 // reverse the current k group .
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int c = 0;
        ListNode temp = head;
        while(c < k){
            if(temp == null){
                return head;
            }
            temp = temp.next;
            c++;
        }
        ListNode prev = reverseKGroup(temp , k);

        temp = head;
        c=0;
        while(c<k){
            ListNode next = temp.next;
            temp.next = prev ;
            prev = temp ;
            temp = next;
            c++;
        }
        return prev;
    }

}