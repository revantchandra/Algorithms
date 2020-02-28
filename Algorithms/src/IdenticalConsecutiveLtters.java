public class IdenticalConsecutiveLtters {
    public static void main(String[] args) {
        IdenticalConsecutiveLtters icl = new IdenticalConsecutiveLtters();
        System.out.println("the result is " + icl.moveCount("baabab"));
    }

    int moveCount(String s) {
        int i = 1, consecutive_count = 0, move_count = 0;

        while (i < s.length()) {

            if (s.charAt(i - 1) == s.charAt(i)) {
                consecutive_count++;
            }
            if (consecutive_count > 2) {
                move_count++;
                consecutive_count = 1;
            }
            i++;
        }
        return move_count;
    }
}// time complexity is O(n) and space complexity is O(1)
