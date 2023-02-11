import entity.ListNode;

public class Question024 {

    public static void main(String[] args) {
        Question024 question024 = new Question024();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode listNode = question024.swapPairs(head);
    }
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) { // 零元素或单元素
            return head;
        }
        ListNode first = recursive(head); // 交换左并连接右
        ListNode second = first.next;
        while (second.next != null) {
            ListNode next = recursive(second.next); // 交换左并连接右
            second.next = next; // 连接左
            if (next.next != null) { // 右移指针
                second = next.next;
            } else {
                return first;
            }
        }
        return first;
    }

    public ListNode recursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode q = p.next;
        ListNode r = q.next;
        q.next = p;
        p.next = r;
        return q;
    }
}
