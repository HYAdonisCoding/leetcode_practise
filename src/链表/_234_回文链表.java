package 链表;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * 
 * @author adam
 *
 */
public class _234_回文链表 {
	public static boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		if (head.next.next == null) {
			return head.val == head.next.val;
		}
		// 找到中间节点
		ListNode mid = middleNode(head);

		ListNode rHead = reverseList(mid.next);

		ListNode lHead = head;
		ListNode oldHeadListNode = rHead;
		boolean result = true;
		while (rHead != null) {
			if (lHead.val != rHead.val) {
				result = false;
				break;
			}
			rHead = rHead.next;
			lHead = lHead.next;
		}
		/// 恢复右半部分(对右半部分再次翻转)
		reverseList(oldHeadListNode);
		return result;
	}

	/**
	 * 找到中间节点(右半部分链表头结点的前一个节点) 比如1>2>3>2>1的3是中间节点 比如1>2>2>1的左边第一个2是中间节点
	 * 
	 * @param head
	 * @return
	 */
	private static ListNode middleNode(ListNode head) {
		ListNode lHead = head;
		ListNode fHead = lHead;

		while (fHead.next != null && fHead.next.next != null) {
			fHead = fHead.next.next;
			lHead = lHead.next;
		}
		return lHead;
	}

	/**
	 * 翻转链表
	 *
	 * @param head 原链表的头结点
	 * @return 翻转后链表的头结点
	 */
	private static ListNode reverseList(ListNode head) {
		ListNode newHead = null;
		while (head != null) {
			ListNode tmp = head.next;
			head.next = newHead;
			newHead = head;
			head = tmp;
		}
		return newHead;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
//		head.next.next.next.next = new ListNode(1);

		System.out.println(head);
		System.out.println(isPalindrome(head));
		System.out.println(head);

	}
}
