package TreeDS;

import sun.lwawt.macosx.CSystemTray;

public class SwappedBSTNodes {
    BinaryTree pre = null,
                first = null,
                second = null,
                middle=null;
    public static void main(String[] args) {

        BinaryTree root = new BinaryTree(6);
        root.left = new BinaryTree(10);
        root.right = new BinaryTree(2);
        root.left.left = new BinaryTree(1);
        root.left.right = new BinaryTree(3);
        root.right.right = new BinaryTree(12);
        root.right.left = new BinaryTree(7);


        TreeTraversal traversal = new TreeTraversal();
        SwappedBSTNodes swap = new SwappedBSTNodes();
        swap.setBst(root);

        traversal.inOrder(root);
    }

    void setBst(BinaryTree root){

        if(root == null){
            return;
        }

        setBst(root.left);

        if(pre != null){

            if(pre.data > root.data){

                if(first == null){
                    first = pre;
                    middle = root;
                } else {
                    second = root;
                }
                System.out.println("test "+ first.data);
            }

            if(first != null && second != null){

                int tmp =first.data;
                first.data = second.data;
                second.data=tmp;
            } else if(first != null && middle != null)  {
                int tmp = first.data;
                first.data=middle.data;
                middle.data = tmp;
            }

        }

        pre = root;

        setBst(root.right);
    }
}
