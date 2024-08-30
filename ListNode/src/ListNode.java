public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode merge(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(), last = head;

        while (null != list1 && null != list2) {
            if (list1.val > list2.val) {
                last.next = list2;
                list2 = list2.next;
            } else {
                last.next = list1;
                list1 = list1.next;
            }

            last = last.next;
        }

        if (null != list1) {
            last.next = list1;
        } else {
            last.next = list2;
        }

        // Omit the first
        return head.next;
    }

    public static ListNode removeOdd(ListNode head) {
        for (; null != head; head = head.next) {
            if (0 == head.val %2) {
                break;
            }
        }

        if (null == head) {
            return null;
        }

        ListNode newHead = head, last = head;
        head = head.next;
        for (; null != head; head = head.next) {
            if (0 == head.val % 2) {
                last.next = head;
                last = last.next;
            }
        }
        last.next = null;

        return newHead;
    }

    // For test only
    public void printList() {
        ListNode head = this;
        while (null != head) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Test codes
    public static void main(String[] args) {
        ListNode list11 = new ListNode(6);
        ListNode list12 = new ListNode(5, list11);
        ListNode list13 = new ListNode(3, list12);
        ListNode list1 = new ListNode(2, list13);
        list1.printList();

        ListNode list21 = new ListNode(17);
        ListNode list22 = new ListNode(0, list21);
        ListNode list2 = new ListNode(-8, list22);
        list2.printList();

        ListNode list3 = merge(list1, list2);
        list3.printList();

        ListNode list4 = removeOdd(list3);
        if (null != list4) {
            list4.printList();
        }
    }
}
