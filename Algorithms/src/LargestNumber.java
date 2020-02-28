public class LargestNumber {
    public static void main(String[] args) {
        LargestNumber largestNumber = new LargestNumber();
        int[] input = new int[]{3, 30, 34, 5, 9};
        System.out.println("largest number can be formed with given array of numbers is "+ largestNumber.largest(input));
    }

    int largest(int[] arr){
        String resultStr =String.valueOf(arr[0]);

        for(int i=1;i<arr.length;i++){
           // System.out.println("test is "+ Integer.parseInt(resultStr+String.valueOf(arr[i]))+ "  "+ Integer.parseInt(String.valueOf(arr[i])+resultStr));
            if(Integer.parseInt(resultStr+String.valueOf(arr[i])) > Integer.parseInt(String.valueOf(arr[i])+resultStr)) {
                resultStr = resultStr+String.valueOf(arr[i]);
            } else {
                resultStr = String.valueOf(arr[i])+resultStr;
            }
        }
        return Integer.parseInt(resultStr);
    }
}
