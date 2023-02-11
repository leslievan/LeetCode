import entity.ListNode;

public class Question019 {

    public static void main(String[] args) {
        Question019 question019 = new Question019();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode head2 = new ListNode(1);
        System.out.println(question019.removeNthFromEnd(head2, 1).val);;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fakeHead = new ListNode(0, head);
        ListNode p = fakeHead, q = head;
        for (int i = 0; i < n; ++i) {
            q = q.next;
        }
        while (q != null) {
            q = q.next;
            p = p.next;
        }
        p.next = p.next.next;
        return fakeHead.next;
    }
}
