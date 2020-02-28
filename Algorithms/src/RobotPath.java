import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class RobotPath {

    public static void main(String[] args) {
        RobotPath robotPath = new RobotPath();
        System.out.println("the result is "+ robotPath.uniqPaths(3,3));
    }

    int uniqPaths(int m, int n){

        return UniqPathUtil(m,n,1,1);

    }

    int UniqPathUtil(int p, int q,int i, int j){

        if(i>p){
            return 0;
        }

        if(j>q){
            return 0;
        }

       if(i== p || j== q){
           //System.out.println("the test "+ i+ "  "+ j);
           return 1;
       }

       return UniqPathUtil(p,q,i,j+1)+UniqPathUtil(p,q,i+1,j);
    }


}
