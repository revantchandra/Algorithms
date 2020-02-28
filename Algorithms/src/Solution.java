class Solution {

    void main(){
        Solution ab = new Solution();
        System.out.println("test is "+ ab.createString(10,12));
    }

    String createString(int N, int K) {
        int aCount = N, frontBcount = 0, endBcount = 0, pairs = 0;

        while (pairs != K) {

            pairs = aCount * endBcount;

            if (pairs == K) {

                StringBuilder str = new StringBuilder();
                int i = 0;
                while (i < frontBcount) {
                    str.append("B");
                    i++;
                }
                i = 0;
                while (i < aCount) {
                    str.append("A");
                    i++;
                }
                i = 0;
                while (i < endBcount) {
                    str.append("B");
                    i++;
                }
                return str.toString();
            } else if (pairs < K) {
                endBcount++;
                aCount--;
            } else {
                frontBcount++;
                aCount--;
            }
        }
        return "";
    }

}