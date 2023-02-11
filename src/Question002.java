import entity.ListNode;

public class Question002 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode n2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        Question002 question002 = new Question002();
        ListNode result = question002.addTwoNumbers(n1, n2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int length1 = 0, length2 = 0;
        ListNode p1 = l1, p2 = l2;
        while (p1.next != null) {
            length1++;
            p1 = p1.next;
        }
        while (p2.next != null) {
            length2++;
            p2 = p2.next;
        }
        if (length2 > length1) {
            for (int i = 0; i < length2 - length1; ++i) {
                p1.next = new ListNode();
                p1 = p1.next;
            }
        } else if (length1 > length2) {
            for (int i = 0; i < length1 - length2; ++i) {
                p2.next = new ListNode();
                p2 = p2.next;
            }
        }
        p1 = l1;
        p2 = l2;
        int carry = 0;
        ListNode result = new ListNode();
        ListNode p3 = result;
        while (p1 != null) {
            int resultVal = p1.val + p2.val + carry;
            p3.next = new ListNode(resultVal % 10, null);
            p1 = p1.next;
            p2 = p2.next;
            p3 = p3.next;
            carry = resultVal / 10;
        }
        if (carry != 0) {
            p3.next = new ListNode(carry, null);
        }
        result = result.next;
        return result;
    }
}
