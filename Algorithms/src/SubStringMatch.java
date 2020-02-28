public class SubStringMatch {
    static String str = "lets test this";
    static String pat = "test t";

    public static void main(String[] args) {
        SubStringMatch ssm = new SubStringMatch();
        int st=0, i=0, j=0;
        System.out.println("is substring match with recursion "+ ssm.isPatMatchRecursive(str,pat,0,0));
        System.out.println("is substring match "+ ssm.isPatMatch(str,pat));
    }

    boolean isPatMatch(String s, String p) {
        int st=0, i=0, j=0;
        while(j<p.length() && i<s.length()){
            if(s.charAt(i) == p.charAt(j)){
                if(j == p.length()-1){
                    return true;
                }
                i++;
                j++;
            } else {
                i = st+1;
                st = i;
                j =0;
            }
        }

        return false;
    } // Run time is O(n) and space is O(1)

    boolean isPatMatchRecursive(String s, String p, int i, int j){

        if(j == p.length()-1){

            if(p.charAt(j) == s.charAt(i)){
                return true;
            }else {
                return false;
            }
        }

        if(i == s.length() - 1){
            if(j == s.length()-1 && s.charAt(j) == p.charAt(i)){
                return true;
            } else {
                return false;
            }
        }

        if(s.charAt(i) == p.charAt(j)){
            return isPatMatchRecursive(s, p,i+1, j+1);
        } else {
            return isPatMatchRecursive(s,p,i-j+1,0);
        }
    }

}
