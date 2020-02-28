package searchingalgorithms;

import java.util.*;
import java.util.stream.IntStream;

public class Search {
    static List<Integer> input = new ArrayList<Integer>();

    public static void main(String[] args) {
        Search search = new Search();

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            input.add(sc.nextInt());
        }

        //System.out.println("Linear search output is "+ search.linearSearch(input, 10));
        //System.out.println("Binary search output is "+ search.binarySearch(input, 10));
        System.out.println("Jump search output is "+ search.jumpSearch(input, 10));

    }

    public int linearSearch(List<Integer> list, int val){
        /*for (int i : list){
            return i == val ? val : -1;
        }
         return -1;*/
        return list.stream().filter(elem -> elem.equals(val)).findFirst().orElse(-1);
    } // time Complexity O(n) , space complexity O(1)

    public int binarySearch(List<Integer> list, int val){
        Collections.sort(list);

        int start =0, end = list.size();
        int mid = 0;
        while(start < end){
            mid = (start+end)/2;
            if(list.get(mid) == val){
                return  val;
            } else if(list.get(mid) > val) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return -1;
    } //time complexity O(logn) , space complexity O(1)

    public int jumpSearch(List<Integer> list, int val){
        Collections.sort(list);

        int size = list.size(),
                block = (int) Math.sqrt(size),
                st = 0,
                end = block;

        while(end < size && list.get(end) < val){
            st = end;
            end = st+block;
        }

        int index = IntStream.range(st,end-1).filter(i -> list.get(i).equals(val)).findFirst().orElse(-1);

        return index != -1 ? list.get(index) : -1;
    } // time complexity O(sqrt(n)) , space complexity O(1)


}
