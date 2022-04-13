package 链表;

//https://leetcode-cn.com/problems/reverse-linked-list/
public class _206_反转链表 {

	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHeadListNode = null;

		while (head != null) {
			ListNode tmp = head.next;

			head.next = newHeadListNode;
			newHeadListNode = head;
			head = tmp;
		}
		return newHeadListNode;
	}

	public ListNode reverseList2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHeadListNode = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return newHeadListNode;

	}
}
