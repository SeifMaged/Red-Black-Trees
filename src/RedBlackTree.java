public class RedBlackTree {
    TreeNode root;

    public RedBlackTree(TreeNode root) {
        this.root = root;
    }

    public boolean search(String key) {
        return search(key, root);
    }

    private boolean search(String key, TreeNode root) {
        if (root == null) {
            return false;
        }
        int result = key.compareToIgnoreCase(root.data);

        if (result == 0) {
            return true;
        }
        if (result < 0) {
            return search(key, root.left);
        }
        return search(key, root.right);
    }

    public int getBlackHeight() {
        return getBlackHeight(root, 0);
    }

    private int getBlackHeight(TreeNode root, int blackHeight) {
        if (root != null) {
            return (root.isRed) ? getBlackHeight(root.left, blackHeight) : getBlackHeight(root.left, blackHeight + 1);
        }
        return blackHeight;
    }

    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    public int getSize() {
        return getSize(root);
    }

    private int getSize(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + getSize(root.left) + getSize(root.right);
    }
}
