package 链表;

/**
 * https://leetcode-cn.com/problems/partition-list/
 * 
 * @author adam
 *
 */
public class _86_分隔链表 {
	public ListNode partition(ListNode head, int x) {
		if (head == null)
			return null;
		ListNode lHead = new ListNode(0);
		ListNode lTail = lHead;
		ListNode rHead = new ListNode(0);
		ListNode rTail = rHead;

		while (head != null) {
			if (head.val < x) { // 放在lTail后面
				lTail = lTail.next = head;
			} else {// 放在rTail后面
				rTail = rTail.next = head;
			}
			head = head.next;
		}
		// 这句不能少
		rTail.next = null;
		lTail.next = rHead.next;
		return lHead.next;
	}
}
