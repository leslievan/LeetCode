import entity.ListNode;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Question023 {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> nodes = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode list : lists) {
            if (list != null) {
                nodes.add(list);
            }
        }
        ListNode fakeHead = new ListNode(0);
        ListNode tail = fakeHead;
        while (!nodes.isEmpty()) {
            ListNode min = nodes.poll();
            tail.next = min;
            tail = tail.next;
            if (min.next != null) {
                nodes.add(min.next);
            }
        }
        return fakeHead.next;
    }
}
