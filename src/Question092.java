import entity.ListNode;
import java.util.ArrayList;
import java.util.List;

public class Question092 {

    public static void main(String[] args) {
        Question092 question092 = new Question092();
        question092.reverseBetween(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))),
                1, 1);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        left = left - 1;
        right = right - 1;
        List<ListNode> nodes = new ArrayList<>();
        ListNode newHead = new ListNode();
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }
        int i = 0;
        ListNode p = newHead;
        while (i < left) {
            p.next = nodes.get(i);
            p = p.next;
            i++;
        }
        i = right;
        while (i >= left && i <= right) {
            p.next = nodes.get(i);
            p = p.next;
            i--;
        }
        i = right + 1;
        while (i > right && i < nodes.size()) {
            p.next = nodes.get(i);
            p = p.next;
            i++;
        }
        p.next = null;
        return newHead.next;
    }

}
