public class ABoardGame {

    public static void main(String[] args) {
        ABoardGame game = new ABoardGame();
       String[] input = new String[]{"BBB..BAB...B.B", ".AAAAAAAAAAAA.", "AA.AA.AB..A.AB", "..........B.AB", ".A..BBAB.A.BAB", ".AB.B.......A.", ".A..A.AB.A..AB", ".ABAA.BA...BA.", "BAAAB.....ABA.", ".A....B..A..B.", "B...B....B..A.", "BA.B..A.ABA.A.", "BAAAA.AAAAA.A.", "B.B.B.BB.B...."};

        System.out.println("The result is "+ game.findWinner(input));
    }


    String findWinner(String[] ip){
        int rowLen = ip.length,
             colLen = ip[0].length();
        String result = "Draw";

        for(int i=(rowLen/2)-1; i>=0; i--){

            int rowStart = i,
                    rowEnd = rowLen-i,
                    colStart = i,
                    colEnd = colLen-i;
            int countA =0, countB=0;
            for(int j=rowStart; j<rowEnd;j++){
                for(int k=colStart; k<colEnd;k++){

                    if(ip[j].charAt(k) == 'A'){
                        countA++;
                    } else if(ip[j].charAt(k) == 'B'){
                        countB++;
                    }
                }
            }
            if(countA > countB) {
                result = "Alice";
            }

            if(countB > countA){
                result = "BOB";
            }

            if(result != "Draw"){
                break;
            }

        }

        return result;
    }

}
