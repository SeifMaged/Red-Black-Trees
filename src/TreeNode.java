public class TreeNode {
    private String data;
    private TreeNode left;
    private TreeNode right;
    private TreeNode parent;
    private boolean isRed;

    public TreeNode(String data, TreeNode left, TreeNode right, TreeNode parent, boolean isRed) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.isRed = isRed;
    }
    public TreeNode(String key){
        this(key, null, null, null, true);
    }

    public String getData() {
        return data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public TreeNode getParent() {
        return parent;
    }

    public boolean isRed() {
        return isRed;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public void colorRed() {
        isRed = true;
    }
    public void colorBlack(){
        isRed = false;
    }
}
