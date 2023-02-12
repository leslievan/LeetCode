import entity.TreeNode;

public class Question099 {

    public static void main(String[] args) {
        Question099 question099 = new Question099();
        question099.recoverTree(new TreeNode(
                3,
                new TreeNode(1), new TreeNode(4, new TreeNode(2), null)));

    }
    public void recoverTree(TreeNode root) {
        traverse(root);
        if (secondMin==null) {
            int middle = firstMax.val;
            firstMax.val = firstMin.val;
            firstMin.val = middle;
        } else {
            int middle = firstMax.val;
            firstMax.val = secondMin.val;
            secondMin.val = middle;
        }
    }

    TreeNode pre = new TreeNode(Integer.MIN_VALUE);
    boolean viewed = false;
    boolean isFirst = true;
    TreeNode firstMin = null;
    TreeNode firstMax = null;
    TreeNode secondMin = null;
    TreeNode secondMax = null;
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        if (viewed && isFirst && root.val <= pre.val) {
            firstMin = root;
            firstMax = pre;
            isFirst = false;
        } else if (viewed && !isFirst && root.val <= pre.val) {
            secondMin = root;
            secondMax = pre;
        }
        pre = root;
        viewed = true;
        traverse(root.right);
    }
}
