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
    static class Node{
        int value ;
        ListNode node;

        Node(int value , ListNode node ){
            this.value = value;
            this.node = node;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.value - b.value);
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0 ;i<lists.length ;i++){
            if (lists[i] != null) {
                pq.offer(new Node(lists[i].val, lists[i]));
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(!pq.isEmpty()){
            Node curr = pq.poll();

            tail.next = curr.node;
            tail = tail.next;

            if(curr.node.next != null){
                pq.offer(new Node(curr.node.next.val , curr.node.next));
            }
        }
    return dummy.next;
    }
}