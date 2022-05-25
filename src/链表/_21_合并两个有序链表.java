package 链表;

/**
 * @auther adam
 * @date 2022/5/24
 * @apiNote 链表
 * https://leetcode.cn/problems/merge-two-sorted-lists
 */
public class _21_合并两个有序链表 {
    // 虚拟头结点
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head = new ListNode(0);;
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur = cur.next = list1;
                list1 = list1.next;
            } else {
                cur = cur.next = list2;
                list2 = list2.next;
            }
        }
        if (list1 == null) {
            cur.next = list2;
        } else if (list2 == null) {
            cur.next = list1;
        }

        return head.next;
    }

    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head;
        if (list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur = cur.next = list1;
                list1 = list1.next;
            } else {
                cur = cur.next = list2;
                list2 = list2.next;
            }
        }
        if (list1 == null) {
            cur.next = list2;
        } else if (list2 == null) {
            cur.next = list1;
        }

        return head;
    }
}
