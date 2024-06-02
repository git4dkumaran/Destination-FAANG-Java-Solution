package meta.leet;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
public class ValidBST {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public boolean isValidBST(TreeNode root) {

		return isValidBST(root, null, null);
//		
//		if (root != null) {
//			if (root.left != null && root.left.val > root.val) {
//				return false;
//			}
//
//			if (root.right != null && root.right.val < root.val) {
//				return false;
//			}
//		}
//		return true;
	}

	public boolean isValidBST(TreeNode root, Integer min, Integer max) {
		if (root == null)
			return true;

		if (min != null && root.val <= min)
			return false;
		if (max != null && root.val >= max)
			return false;
		return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
	}

	public static void main(String[] args) {
		System.out.println("test... "); // [2,2,2]
	}

}
