public class RedBlackTree {
    TreeNode root;

    public RedBlackTree(TreeNode root) {
        this.root = root;
    }

    public int getBlackHeight(){
        return getBlackHeight(root, 0);
    }
    private int getBlackHeight(TreeNode root, int blackHeight){
        if(root != null){
           return (root.isRed) ? getBlackHeight(root.left, blackHeight) : getBlackHeight(root.left, blackHeight + 1);
        }
        return blackHeight;
    }

}
