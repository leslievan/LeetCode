import entity.ListNode;

public class Question021 {

    public static void main(String[] args) {
        Question021 question021 = new Question021();
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode head2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        question021.mergeTwoLists(head1, head2);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode fakeHead = new ListNode(0);
        ListNode tail = fakeHead;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        while (list1 != null) {
            tail.next = list1;
            tail = tail.next;
            list1 = list1.next;
        }
        while (list2 != null) {
            tail.next = list2;
            tail = tail.next;
            list2 = list2.next;
        }
        return fakeHead.next;
    }
}
