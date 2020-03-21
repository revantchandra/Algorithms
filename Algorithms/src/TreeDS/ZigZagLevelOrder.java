package TreeDS;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagLevelOrder {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);
        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(5);
        tree.right.left = new BinaryTree(6);
        tree.right.right = new BinaryTree(7);
        tree.right.left.left = new BinaryTree(8);

        ZigZagLevelOrder zigZagTraversal = new ZigZagLevelOrder();

        zigZagTraversal.doZigZagTraversal(tree);
    }

    void doZigZagTraversal(BinaryTree root){

        Deque<BinaryTree> deque = new LinkedList<BinaryTree>();
        boolean isReverse = false;
        deque.addFirst(root);
        while (!deque.isEmpty()){
            int size = deque.size(),
                    i=0;

            while(i<size){
                if(isReverse){
                    BinaryTree tmp = deque.pollFirst();
                    System.out.print(tmp.data+" ");
                    if(tmp.right != null)
                        deque.addLast(tmp.right);
                    if(tmp.right != null)
                        deque.addLast(tmp.left);
                }else {
                    BinaryTree tmp1 = deque.pollLast();
                    System.out.print(tmp1.data+" ");
                    if(tmp1.left != null)
                        deque.addFirst(tmp1.left);
                    if(tmp1.right != null)
                        deque.addFirst(tmp1.right);
                }
                i++;
            }

            if(isReverse){
                isReverse = false;
            }else {
                isReverse = true;
            }
            System.out.println();
        }


    }
}
