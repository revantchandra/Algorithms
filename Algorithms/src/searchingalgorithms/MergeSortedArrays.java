package searchingalgorithms;

import java.util.Arrays;

public class MergeSortedArrays {

     public static void main(String[] args) {
         int[] arr1 = new int[]{1,5, 7,9, 14,16};
         int[] arr2 = new int[]{3,12, 16, 18, 24,25};
         MergeSortedArrays msa = new MergeSortedArrays();
         int[] re = msa.merge(arr1,arr2);

         Arrays.stream(re).forEach(ele -> System.out.println(ele));
    }

    int[] merge(int[] a1, int[] a2) {
         int i=0, j=0, k=0;
         int[] result = new int[a1.length+a2.length];

         while(i<a1.length && j<a2.length){
             if(a1[i] < a2[j]){
                 result[k] = a1[i]; // 1
                 i++;
                 k++;
             }else if(a1[i] > a2[j]){
                 result[k] = a2[j];
                 j++;
                 k++;
             } else {
                 result[k] = a1[i];
                 i++;
                 j++;
                 k++;
             }
         }
         while (i<a1.length){
             result[k] = a1[i];
             i++;
             k++;
         }

        while (j<a2.length){
            result[k] = a2[j];
            j++;
            k++;
        }

        return result;
    } // time complexity O(n1+n2) and space complexity O(n1+n2)
}
