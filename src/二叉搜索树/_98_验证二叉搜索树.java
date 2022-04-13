package 二叉搜索树;

/**	https://leetcode-cn.com/problems/validate-binary-search-tree/
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * */
public class _98_验证二叉搜索树 {
	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}

		return isValid(root);
	}

	private boolean isValid(TreeNode node) {
		if (node == null) {
			return true;
		}
		if (node.left != null) {
			if (node.left.val < node.val) {
				return isValid(node.left);
			} else {
				return false;
			}
		}

		if (node.right != null) {
			if ( node.right.val > node.val) {
				System.out.println(node.right.val + "-" + node.val);
				return isValid(node.right);
			} else  {
				return false;
			}

		}
		return true;
	}

	public static void main(String[] args) {
		//[5,1,4,null,null,3,6]
		TreeNode node = new TreeNode(5);
		node.left = new TreeNode(1);
		node.right = new TreeNode(4);
		node.right.left = new TreeNode(3);
		node.right.right = new TreeNode(6);

		_98_验证二叉搜索树 o = new _98_验证二叉搜索树();
		System.out.println(o.isValidBST(node));

	}
}
