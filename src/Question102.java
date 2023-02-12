import entity.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Question102 {

    public static void main(String[] args) {
        Question102 question102 = new Question102();
        question102.levelOrder(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Queue<TreeNode>[] queues = new Queue[2];
        queues[0] = new LinkedList<>();
        queues[1] = new LinkedList<>();
        int pointer = 0;

        List<List<Integer>> result = new ArrayList<>();
        queues[pointer].add(root);

        List<Integer> middle = new ArrayList<>();
        while (!queues[pointer].isEmpty()) {
            TreeNode remove = queues[pointer].remove();
            middle.add(remove.val);
            if (remove.left != null) {
                queues[(pointer + 1) % 2].add(remove.left);
            }
            if (remove.right != null) {
                queues[(pointer + 1) % 2].add(remove.right);
            }
            if (queues[pointer].isEmpty()) {
                pointer = (pointer + 1) % 2;
                result.add(middle);
                middle = new ArrayList<>();
            }
        }
        return result;
    }
}
