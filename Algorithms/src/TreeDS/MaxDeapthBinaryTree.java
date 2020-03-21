package TreeDS;

public class MaxDeapthBinaryTree {
    public static void main(String[] args) {
        MaxDeapthBinaryTree mdbt = new MaxDeapthBinaryTree();
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);
        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(5);
        tree.right.left = new BinaryTree(6);
        tree.right.right = new BinaryTree(7);
        tree.right.left.left = new BinaryTree(8);

        System.out.println("the maximum deapth of binary tree is "+ mdbt.calcMaxDeapth(tree));
    }

    int calcMaxDeapth(BinaryTree root){

        if(root == null){
            return 0;
        }

        return 1+Math.max(calcMaxDeapth(root.left),calcMaxDeapth(root.right));

    }
}
