import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddOne {
    public static void main(String[] args) {
        AddOne addone = new AddOne();
        List<Integer> ip = new ArrayList<>();
        ip.add(9);
        ip.add(9);
        ip.add(9);
        System.out.println("the result is "+ addone.plusOne((ArrayList<Integer>) ip));
    }

    ArrayList<Integer> plusOne(ArrayList<Integer> list){
        int size= list.size(),
                sum=list.get(size-1);
            //i=list.size()-1;

        if(sum == 9){
            int i=0;

            while(sum >= 9){
               if(i<size-1){
                   list.set(size-i-1,0);
                    //System.out.println("test "+(sum+1)/10);
                    list.set(size-i-2,list.get(size-i-2)+(sum+1)/10);
                   sum=list.get(size-i-2)+(sum+1)/10;
                    i++;
               }else {
                   int m=1;
                   list.add(-1);
                   while (m<list.size()){
                       list.set(list.size()-m,list.get(list.size()-m-1));
                       m++;
                   }
                   list.set(0,1);
                   list.set(1,0);
                   sum=1;
               }
            }
        }else {
            list.set(size,list.get(size)+1);
        }
        return list;
    }
}
