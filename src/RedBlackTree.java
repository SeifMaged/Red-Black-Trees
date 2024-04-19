public class RedBlackTree {
    private TreeNode root;

    public RedBlackTree(TreeNode root) {
        this.root = root;
    }

    public RedBlackTree() {
        this.root = null;
    }

    public TreeNode getRoot() {
        return root;
    }

    public TreeNode search(String key) {
        return search(key, root);
    }

    private TreeNode search(String key, TreeNode root) {
        if (root == null) {
            return null;
        }
        int result = key.compareToIgnoreCase(root.getData());

        if (result == 0) {
            return root;
        }
        if (result < 0) {
            return search(key, root.getLeft());
        }
        return search(key, root.getRight());
    }

    private TreeNode getUncle(TreeNode node) {
        TreeNode parent = node.getParent();
        TreeNode grandparent = parent.getParent();

        if (grandparent.getLeft() == parent) {
            return grandparent.getRight();
        }
        return grandparent.getLeft();
    }

    private void rotateLeft(TreeNode node) {
        TreeNode parent = node.getParent();
        TreeNode rightChild = node.getRight();

        node.setRight(rightChild.getLeft());

        if (rightChild.getLeft() != null) {
            rightChild.getLeft().setParent(node);
        }

        rightChild.setLeft(node);
        node.setParent(rightChild);

        replaceParentChild(parent, node, rightChild);
    }

    private void rotateRight(TreeNode node) {
        TreeNode parent = node.getParent();
        TreeNode leftChild = node.getLeft();

        node.setLeft(leftChild.getRight());

        if (leftChild.getRight() != null) {
            leftChild.getRight().setParent(node);
        }

        leftChild.setRight(node);
        node.setParent(leftChild);

        replaceParentChild(parent, node, leftChild);
    }

    private void replaceParentChild(TreeNode parent, TreeNode oldChild, TreeNode newChild) {
        if (parent == null) {
            root = newChild;
        } else if (parent.getLeft() == oldChild) {
            parent.setLeft(newChild);
        } else if (parent.getRight() == oldChild) {
            parent.setRight(newChild);
        }

        if (newChild != null) {
            newChild.setParent(parent);
        }
    }

    public void insert(String key) {
        TreeNode node = root;
        TreeNode parent = null;
        int result;

        while (node != null) {
            result = key.compareToIgnoreCase(node.getData());
            parent = node;
            if (result < 0) {
                node = node.getLeft();
            } else if (result > 0) {
                node = node.getRight();
            }
        }

        TreeNode newNode = new TreeNode(key); // directly set the color to red

        if (parent == null) {
            root = newNode;
        } else {
            result = key.compareToIgnoreCase(parent.getData());
            if (result < 0) {
                parent.setLeft(newNode);
            } else if (result > 0) {
                parent.setRight(newNode);
            }
        }
        newNode.setParent(parent);

        fixAfterInsertion(newNode);
    }

    private void fixAfterInsertion(TreeNode node) {
        TreeNode parent = node.getParent();

        // if parent is null then node is the root make it black
        if (parent == null) {
            node.colorBlack();
            return;
        }

        // if parent is black then do nothing
        if (!parent.isRed()) {
            return;
        }

        /*
         * parent is red
         */

        TreeNode grandParent = parent.getParent();

        // parent is the root so make it black
        if (grandParent == null) {
            parent.colorBlack();
            return;
        }

        TreeNode uncle = getUncle(node);

        // recolor if the uncle is red
        if (uncle != null && uncle.isRed()) {
            parent.colorBlack();
            grandParent.colorRed();
            uncle.colorBlack();

            // to make sure that there is no 2 consecutive red nodes or the root colored red
            fixAfterInsertion(grandParent);
        } else if (grandParent.getLeft() == parent) {
            if (node == parent.getRight()) {
                rotateLeft(parent);
                parent = node;
            }
            rotateRight(grandParent);
            parent.colorBlack();
            grandParent.colorRed();
        } else {
            if (node == parent.getLeft()) {
                rotateRight(parent);
                parent = node;
            }
            rotateLeft(grandParent);
            parent.colorBlack();
            grandParent.colorRed();
        }
    }

    public void printAll() {
        dfs(root);
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.getLeft());
        System.out.println(node.getData());
        dfs(node.getRight());
    }

    public int getBlackHeight() {
        return getBlackHeight(root, 0);
    }

    private int getBlackHeight(TreeNode root, int blackHeight) {
        if (root != null) {
            return (root.isRed()) ? getBlackHeight(root.getLeft(), blackHeight)
                    : getBlackHeight(root.getLeft(), blackHeight + 1);
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
        return 1 + Math.max(getHeight(root.getLeft()), getHeight(root.getRight()));
    }

    public int getSize() {
        return getSize(root);
    }

    private int getSize(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + getSize(root.getLeft()) + getSize(root.getRight());
    }
}
