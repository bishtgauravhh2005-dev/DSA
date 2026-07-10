/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Node newhead = new Node(head.val);
        Node old = head.next;
        Node newh = newhead;
        HashMap<Node , Node> m = new HashMap<>();
        m.put(head, newhead);
        while(old !=null){
            Node next = new Node(old.val);
            m.put(old,next);
            newh.next = next;
            newh = newh.next;
            old = old.next;
        }

        Node old_temp = head;
        Node new_temp = newhead;
        while(old_temp!=null){
            new_temp.random = m.get(old_temp.random);
            old_temp = old_temp.next;
            new_temp = new_temp.next;
        }
    return newhead;
    }
}