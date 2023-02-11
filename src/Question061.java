import entity.ListNode;
import java.util.ArrayList;
import java.util.List;

public class Question061 {

    public static void main(String[] args) {
        Question061 question061 = new Question061();
        question061.rotateRight(new ListNode(0, new ListNode(1, new ListNode(2, null))), 1);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        List<ListNode> nodes = new ArrayList<>();
        ListNode tail = head;
        while (tail.next != null) {
            nodes.add(tail);
            tail = tail.next;
        }
        nodes.add(tail);
        k = k % nodes.size();
        if (k == 0 || nodes.size() == 1) {
            return head;
        }
        // 循环链表
        tail.next = head;
        nodes.get(nodes.size() - k - 1).next = null;
        return nodes.get(nodes.size() - k);
    }
}
