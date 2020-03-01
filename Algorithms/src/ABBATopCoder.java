public class ABBATopCoder {

    public static void main(String[] args) {
        ABBATopCoder abbaTopeCoder = new ABBATopCoder();

        System.out.println("the result is "+ abbaTopeCoder.canObtain("B","ABBA"));
        System.out.println("the result is "+ abbaTopeCoder.canObtainRecursion("BBBBABABBBBBBA","BBBBABABBABBBBBBABABBBBBBBBABAABBBAA"));
    }

    String canObtain(String init, String target){

        StringBuilder strBuilder = new StringBuilder(target);

        while(strBuilder.length() != init.length()){
            //System.out.println("test is "+ strBuilder +"  "+ init);
            if(strBuilder.charAt(strBuilder.length()-1) == 'A'){
                strBuilder = strBuilder.deleteCharAt(strBuilder.length()-1);
            } else {
                strBuilder = strBuilder.deleteCharAt(strBuilder.length()-1).reverse();
            }
        }

        return strBuilder.toString().equals(init) ? "POSSIBLE" : "IMPOSSIBLE";
    }

    String canObtainRecursion(String initial, String target) {
        return canObtainRecursionUtil(initial,target) ? "POSSIBLE" : "IMPOSSIBLE";
    }

    boolean canObtainRecursionUtil(String initial, String target) {

        if(initial.length() >= target.length()){

            return initial.equals(target);
        }
        boolean isEqual = false;
        StringBuilder str = new StringBuilder(initial);
        String move1 = new StringBuilder(initial).append('A').toString();
        String move2 = new StringBuilder(initial).reverse().append('B').toString();
        if(target.indexOf(move1) != -1 || new StringBuilder(target).reverse().toString().indexOf(move1) != -1){
            isEqual = isEqual || canObtainRecursionUtil(move1,target);
        }

        if(target.indexOf(move2) != -1 || new StringBuilder(target).reverse().toString().indexOf(move2) != -1){
            isEqual = isEqual || canObtainRecursionUtil(move2,target);
        }


        return isEqual;

    }
}
