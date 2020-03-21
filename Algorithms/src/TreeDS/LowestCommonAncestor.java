package TreeDS;

import javax.swing.*;

public class LowestCommonAncestor {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree(3);
        tree.left = new BinaryTree(5);
        tree.right = new BinaryTree(1);
        tree.left.left = new BinaryTree(6);
        tree.left.right = new BinaryTree(2);
        tree.right.left = new BinaryTree(0);
        tree.right.right = new BinaryTree(8);
        tree.left.right.left = new BinaryTree(7);
        tree.left.right.right = new BinaryTree(4);

        LowestCommonAncestor lca = new LowestCommonAncestor();
        BinaryTree result = lca.findLCA(tree,7,1);
        System.out.println("the lowest common ancestor is "+ result.data);
    }

    BinaryTree findLCA(BinaryTree root, int p, int q){

        if(root == null){
            return null;
        }

        if(root.data == p || root.data == q){
            return root;
        }

        BinaryTree left = findLCA(root.left,p,q);
        BinaryTree right = findLCA(root.right,p,q);

        if(left != null && right == null) {
            return left;
        }

        if(right != null && left== null){
            return right;
        }

        if(left != null && right != null){
            return root;
        }

        return null;

    }


}
