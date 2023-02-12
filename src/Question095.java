import entity.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question095 {

    public static void main(String[] args) {
        Question095 question095 = new Question095();
        question095.generateTrees(3);
    }

    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    List<TreeNode> generateTrees(int start, int end) {
        if (start > end) {
            return Collections.singletonList(null);
        }

        List<TreeNode> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = generateTrees(start, i - 1);
            List<TreeNode> rights = generateTrees(i + 1, end);

            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
