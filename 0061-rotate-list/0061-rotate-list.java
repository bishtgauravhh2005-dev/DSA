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
    //public ListNode reverse(ListNode head , int k ){
        //  Brute Force:
    //     if(k == 0 || head == null){
    //         return head;
    //     }
    //     for( int i=0 ;i<=k ;i++){
    //         ListNode curr = head; 
    //         while(curr.next!=null){
    //             curr = curr.next;
    //         }

    //         curr.next = head;
    //         curr = curr.next;
    //         head = head.next;
    //         curr.next = null;
    //     }
    //     return head;
    // }
     public ListNode rotateRight(ListNode head, int k) {
    //     return reverse(head , k);


    // Optimal approach:
    ListNode curr = head;
    if(k==0 || head == null){
        return head;
    }
    int length = 1;
    while(curr.next != null){
        curr = curr.next;
        length++;
    }
    k%=length;
    if(k == 0){
        return head;
    }
    curr.next = head;

    int steps = length - k;
    while(steps!= 0){
        curr = curr.next;
        steps--;
    }
    head = curr.next;
    curr.next = null;

    return head;
    }
}

