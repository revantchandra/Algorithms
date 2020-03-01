import java.util.*;

public class ABBADiv1 {
    public static void main(String[] args) {
       ABBADiv1 abba = new ABBADiv1();

       System.out.println("result is "+ abba.canObtain("AAABBAABB","BAABAAABAABAABBBAAAAAABBAABBBBBBBABB"));
    }

    String canObtain(String init, String tar){

        return canObtainUtil(init,tar) ? "POSSIBLE" : "IMPOSSIBLE";
    }
    boolean canObtainUtil(String initial, String target){
        if(initial.length() >= target.length()){

            return initial.equals(target);
        }
        boolean isEqual = false;
        StringBuilder str = new StringBuilder(initial);
        String move1 = new StringBuilder(initial).append('A').toString();
        String move2 = new StringBuilder(initial).append('B').reverse().toString();
        if(target.indexOf(move1) != -1 || new StringBuilder(target).reverse().toString().indexOf(move1) != -1){
            isEqual = isEqual || canObtainUtil(move1,target);
        }

        if(target.indexOf(move2) != -1 || new StringBuilder(target).reverse().toString().indexOf(move2) != -1){
            isEqual = isEqual || canObtainUtil(move2,target);
        }


        return isEqual;
    }


}