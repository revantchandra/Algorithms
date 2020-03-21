package TreeDS;

import java.nio.file.Path;

public class PathSum {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);
        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(5);
        tree.right.left = new BinaryTree(6);
        tree.right.right = new BinaryTree(7);
        tree.right.left.left = new BinaryTree(8);

        PathSum pathSum = new PathSum();

        System.out.println("Is path sum equal ti given value "+ pathSum.isEqualToVal(tree,18));
    }

    boolean isEqualToVal(BinaryTree root, int result){
        int sum=0;
        return isEqualToValUtil(root,result,sum);
    }

    boolean isEqualToValUtil(BinaryTree rt, int resVal, int sumVal){

        if(rt == null){
            return sumVal==resVal;
        }

        sumVal = sumVal+rt.data;

        return isEqualToValUtil(rt.left,resVal,sumVal) || isEqualToValUtil(rt.right,resVal,sumVal);

    }
}
