package TreeDS;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import sun.lwawt.macosx.CSystemTray;

import java.util.*;

public class TreeTraversal {
    public static void main(String[] args) {
        TreeTraversal treeTraversal = new TreeTraversal();

        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);
        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(5);
        tree.right.left = new BinaryTree(6);
        tree.right.right = new BinaryTree(7);
        tree.left.right.left = new BinaryTree(8);
        tree.left.right.right = new BinaryTree(9);

//        treeTraversal.inOrder(tree);
//        treeTraversal.inOrderWithoutRecursion(tree);
//        treeTraversal.preOrder(tree);
        //treeTraversal.postOrder(tree);
        treeTraversal.preOrderWithOutRecursion(tree);
    }

    void inOrder(BinaryTree root){

        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+"  ");
        inOrder(root.right);
    }

    void inOrderWithoutRecursion(BinaryTree root){
        Stack<BinaryTree>  treeStack = new Stack<BinaryTree>();

        while(root != null){
            treeStack.push(root);
            root = root.left;
        }

        while(!treeStack.isEmpty()){
            BinaryTree curNode = treeStack.pop();
            System.out.print(curNode.data+"  ");
            curNode = curNode.right;

            while(curNode != null){
                treeStack.push(curNode);
                curNode = curNode.left;
            }
        }
    }

    void preOrder(BinaryTree root){

        if(root == null){
            return;
        }

        System.out.print(root.data+"  ");
        preOrder(root.left);
        preOrder(root.right);
    }

    void preOrderWithOutRecursion(BinaryTree root){

    }

    void  postOrder(BinaryTree root) {

        if(root == null){
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+"  ");
    }

}
