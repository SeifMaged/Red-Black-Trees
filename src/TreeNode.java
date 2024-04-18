public class TreeNode {
    String data;
    TreeNode left;
    TreeNode right;
    TreeNode parent;
    boolean isRed;

    public TreeNode(String data, TreeNode left, TreeNode right, TreeNode parent, boolean isRed) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.isRed = isRed;
    }
}
