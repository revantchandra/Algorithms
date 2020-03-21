package TreeDS;

import java.net.HttpRetryException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RootToLeafSum {
    public static void main(String[] args) {

        RootToLeafSum rtl = new RootToLeafSum();
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);
        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(5);
        tree.right.left = new BinaryTree(6);
        tree.right.right = new BinaryTree(7);
        tree.right.left.left = new BinaryTree(8);

        System.out.println("the result is "+ rtl.doSum(tree));
    }

    int doSum(BinaryTree root){

        return doSumUtil(root,0);


    }

    int doSumUtil(BinaryTree node, int val){

        if (node == null)
            return 0;

        val = (val * 10 + node.data);

        if (node.left == null && node.right == null)
            return val;

        return doSumUtil(node.left, val)
                + doSumUtil(node.right, val);
    }

}
