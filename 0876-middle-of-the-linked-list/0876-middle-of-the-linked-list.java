/**
 * Definition for singly-linked list.**/
//   class ListNode {
//     int val;
//     ListNode next;

//     ListNode(int val) {
//         this.val = val;
//         this.next = null;
//     }
// }

class Solution {
    public ListNode middleNode(ListNode head) {
        int e = 0;
        ListNode temp = head; 
        while(temp!=null){
            e++;
            temp = temp.next;
        }
        int m = 0 +(e-0)/2;
        ListNode t = head; 
        int i =0;
        while(t!=null){
            if(i==m){
                break;
            }
            i++;
            t=t.next;
        }
        
        return t;
    }
}