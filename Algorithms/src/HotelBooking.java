import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HotelBooking {

    public static void main(String[] args) {
        HotelBooking hotelBooking = new HotelBooking();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(3);
        arr.add(7);
        arr.add(9);
        arr.add(13);
        arr.add(17);

        ArrayList<Integer> dep = new ArrayList<>();
        dep.add(2);
        dep.add(6);
        dep.add(8);
        dep.add(11);
        dep.add(15);
        dep.add(18);

        System.out.println("the result is "+ hotelBooking.isBookingAVailable(arr,dep,1));
    }

    boolean isBookingAVailable(ArrayList<Integer> arrival, ArrayList<Integer> departure, int k){

        ArrayList<Integer> auxArrList = arrival;
        Collections.sort(auxArrList);
        ArrayList<Integer> auxDepList = departure;

        for(int i=0; i<auxArrList.size(); i++){
            auxDepList.set(i,departure.get(arrival.indexOf(auxArrList.get(i))));
        }

        if(k>0 && arrival.size() > 0 && departure.size() > 0) {

            for(int j=1; j<arrival.size();j++){
                if(!(departure.get(j-1) < arrival.get(j))){
                    k--;
                }
                if(k<=0){
                    return false;
                }
            }
        }

        return true;

    }
}
