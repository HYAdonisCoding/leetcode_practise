package 链表;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @auther adam
 * @date 2022/5/25
 * @apiNote 链表
 * https://leetcode.cn/problems/merge-k-sorted-lists/
 */
public class _23_合并K个升序链表 {
    /**
     * 思路5： 分治策略
     */
    public ListNode mergeKLists4(ListNode[] lists) {
        if (lists == null || lists.length <= 0) {
            return null;
        }
        int step = 1;
        while (step < lists.length) {
            int currentStep = step * 2;
            for (int i = 0; i+step < lists.length; i += currentStep) {
                lists[i] = mergeTwoLists(lists[i], lists[i+step]);
            }
            step = currentStep;
        }

        return lists[0];
    }
    /**
     * 思路4： 优先级队列 小顶堆
     */
    public ListNode mergeKLists3(ListNode[] lists) {
        if (lists == null || lists.length <= 0) {
            return null;
        }
        ListNode head = new ListNode(0);
        ListNode cur = head;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((ListNode l1, ListNode l2) -> {
            return l1.val - l2.val;
        });
        for (ListNode node : lists) {
            if (node == null) {
                continue;
            }
            queue.offer(node);
        }

        while (!queue.isEmpty()) {
            ListNode list = queue.poll();
            if (list.next != null) {
                queue.offer(list.next);
            }
            cur = cur.next = list;
        }
        return head.next;
    }
    /**
     * 思路3： 逐一两两合并
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length <= 0) {
            return null;
        }
        for (int i = 1; i < lists.length; i++) {
            lists[0] = mergeTwoLists(lists[0], lists[i]);
        }

        return lists[0];
    }
    ListNode head = new ListNode(0);;
    // 虚拟头结点
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        head.next = null;
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
    /**
     * 思路二： 逐一比较
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length <= 0) {
            return null;
        }
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (true) {
            int minIdx = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) { continue; }
                if (minIdx == -1 || lists[i].val < lists[minIdx].val) {
                    minIdx = i;
                }

            }
            // 完成比较
            if (minIdx == -1) break;
            cur = cur.next = lists[minIdx];
            lists[minIdx] = lists[minIdx].next;
        }

        return head.next;
    }
    /**
     * 思路一： 最笨的解法
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length <= 0) {
            return null;
        }
        List<ListNode> list = new ArrayList<>();

        for (int i = 0; i < lists.length; i++) {
            while (lists[i] != null) {
                list.add(lists[i]);
                lists[i] = lists[i].next;
            }
        }
        list.sort((ListNode node1, ListNode node2) -> {
            return node1.val-node2.val;
        });
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (ListNode node : list) {
            cur = cur.next = node;
        }
        return head.next;
    }
}
