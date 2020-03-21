package TreeDS;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import sun.jvm.hotspot.asm.sparc.SPARCArgument;

public class NextRightPointer {

    static class SpecialBinaryTree {

        int data;
        SpecialBinaryTree left;
        SpecialBinaryTree right;
        SpecialBinaryTree next;

        SpecialBinaryTree(int val){
            data = val;
            left = this.right = this.next = null;
        }
    }

    public static void main(String[] args) {
        SpecialBinaryTree tree = new SpecialBinaryTree(1);
        tree.left = new SpecialBinaryTree(2);
        tree.right = new SpecialBinaryTree(3);
        tree.left.left = new SpecialBinaryTree(4);
        //tree.left.right = new SpecialBinaryTree(5);
       tree.right.left = new SpecialBinaryTree(6);
//        tree.right.right = new SpecialBinaryTree(7);
//        tree.right.left.left = new SpecialBinaryTree(8);

        NextRightPointer nextPointer = new NextRightPointer();
        tree.next = null;
        nextPointer.connectNextPointer(tree);
        SpecialBinaryTree tp = tree;
        //System.out.println("test is "+ tp.left.next);
        while (tp != null){

            SpecialBinaryTree t= tp;

            while (t!= null){
                System.out.print(t.data+"  ");
                t = t.next;
            }
            tp = tp.left;
            System.out.println();
        }
    }

    void connectNextPointer(SpecialBinaryTree root){

        while(root != null){

            SpecialBinaryTree tmp = root;
            //System.out.println("test "+ tmp.data);
            while (tmp != null){
                if(tmp.left != null){
                    if(tmp.right != null){
                        tmp.left.next = root.right;
                        tmp.right.next = findNextPointer(tmp);
                    } else {
                        tmp.left.next = findNextPointer(tmp);
                    }
                } else if(root.right != null){
                    tmp.right.next = findNextPointer(tmp);
                }

                tmp = tmp.next;
            }

            while (root != null){

                if(root.left != null){
                    root = root.left;
                    break;
                }else if(root.right != null) {
                    root=root.right;
                    break;
                } else {
                    root = root.next;
                }

            }

        }

    }

    SpecialBinaryTree findNextPointer(SpecialBinaryTree rt){
        while(rt.next != null){

            if(rt.next.left != null){
                return rt.next.left;
            } else if (rt.next.right != null){
                return rt.next.right;
            } else {
                rt.next = rt.next.next;
            }

        }

        return null;
    }


}
