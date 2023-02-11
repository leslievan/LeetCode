import entity.ListNode;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Question082 {

    public static void main(String[] args) {
        Question082 question082 = new Question082();
        question082.deleteDuplicates(new ListNode(1,
                new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5))))))));
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(Integer.MAX_VALUE);
        ListNode p = head, q = newHead;
        while (p != null) {
            if (p.next == null || p.val != p.next.val) {
                q.next = p;
                q = q.next;
            }
            while (p.next != null && p.val == p.next.val) {
                p = p.next;
            }
            p = p.next;
        }
        q.next = null;
        return newHead.next;
    }
}
