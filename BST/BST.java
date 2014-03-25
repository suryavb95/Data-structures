public class BST {
    private BSTNode root;
    //    public BST() {
    //  root = null;
    //}
    
    public BSTNode find(int value) {
        if (root == null) 
            return null;
        else
            return root.find(value);
    }

    public void insert(int data) {
        if (root == null) 
            root = new BSTNode(data);
        else 
            root.insert(data);
    }

    public void preorderTraversal() {
        preorderTraversalHelper(root);
    }

    public void preorderTraversalHelper(BSTNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            // left
            preorderTraversalHelper(node.left);
            // right
            preorderTraversalHelper(node.right);
        }
    }

    public void inorderTraversal() {
        inorderTraversalHelper(root);
    }

    public void inorderTraversalHelper(BSTNode node) {
        if (node != null) {
            // left
            inorderTraversalHelper(node.left);
            System.out.print(node.data + " ");
            // right
            inorderTraversalHelper(node.right);
        }
    }

    public void postorderTraversal() {
        postorderTraversalHelper(root);
    }

    public void postorderTraversalHelper(BSTNode node) {
        if (node != null) {
            // left
            postorderTraversalHelper(node.left);
            // right
            postorderTraversalHelper(node.right);
            System.out.print(node.data + " ");
        }
    }

    private class BSTNode {
        private int data;
        private BSTNode left;
        private BSTNode right;
        public BSTNode(int data) {
            this.data = data;
            // left = null;
            // right = null;
        }

        public BSTNode find(int value) {
            if (value == this.data)
                return this;
            if (value < data) {
                if (left == null)
                    return null;
                else
                    return left.find(value);
            }
            else {
                if (right == null)
                    return null;
                else
                    return right.find(value);
            }
        }


        public void insert(int value) {
            // ignores duplicates
            if (value < data) {
                if (left == null) 
                    left = new BSTNode(value);
                else
                    left.insert(value);
            }
            else if (value > data) {
                if (right == null) 
                    right = new BSTNode(value);
                else
                    right.insert(value);
            }
        }
    }
    public static void main(String[] args) {
        BST myBST = new BST();
        myBST.inorderTraversal();
        myBST.insert(50);
        // myBST.inorderTraversal();
        myBST.insert(50);
        myBST.insert(100);
        myBST.insert(60);
        myBST.insert(200);
        myBST.insert(50);
        myBST.insert(100);
        myBST.insert(60);
        myBST.insert(2000);
        System.out.println("Preorder: ");
        myBST.preorderTraversal();
        System.out.println("inorder: ");
        myBST.inorderTraversal();
        System.out.println("Postorder: ");
        myBST.postorderTraversal();        
    }
}