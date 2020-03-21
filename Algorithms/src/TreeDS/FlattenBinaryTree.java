package TreeDS;

public class FlattenBinaryTree {

    public static void main(String[] args) {
        FlattenBinaryTree FB = new FlattenBinaryTree();
        TreeTraversal traversal = new TreeTraversal();
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);
        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(5);
        tree.right.left = new BinaryTree(6);
        tree.right.right = new BinaryTree(7);
//        tree.left.right.left = new BinaryTree(7);
//        tree.left.right.right = new BinaryTree(4);

        traversal.inOrder(tree);
        System.out.println("/n");
        FB.doFlatten(tree);
        traversal.inOrder(tree);
    }

    void doFlatten(BinaryTree root){
        BinaryTree tmp = null;
        if(root == null){
            return;
        }

        doFlatten(root.left);

        if(root.right != null && root.left != null){
            tmp = root.right;
            root.right = null;
            root.right = root.left;
            root.left = null;
            BinaryTree tmp1 = root;
            while (root.right != null){
                root = root.right;
            }
            root.right = tmp;
            root = tmp1;
        }

        doFlatten(root.right);
    }
}
