import entity.ListNode;

public class Question086 {

    public static void main(String[] args) {
        Question086 question086 = new Question086();
        question086.partition(
                new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2)))))),
                3);
    }
    public ListNode partition(ListNode head, int x) {
        ListNode smaller = new ListNode();
        ListNode bigger = new ListNode();
        ListNode p = head, q = smaller, r = bigger;
        while (p != null) {
            if (p.val < x) {
                q.next = p;
                q = q.next;
            } else {
                r.next = p;
                r = r.next;
            }
            p = p.next;
        }
        r.next = null;
        q.next = bigger.next;
        return smaller.next;
    }
}
