import entity.TreeNode;

public class Question098 {

    int pre = Integer.MIN_VALUE;
    boolean viewed = false;
    boolean result = true;

    public boolean isValidBST(TreeNode root) {
        traverse(root);
        return result;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        if (viewed && root.val <= pre) {
            result = false;
        }
        pre = root.val;
        viewed = true;
        traverse(root.right);
    }
}
