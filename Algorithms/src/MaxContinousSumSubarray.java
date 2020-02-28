public class MaxContinousSumSubarray {

    public static void main(String[] args) {
        MaxContinousSumSubarray mcss = new MaxContinousSumSubarray();
        int[] ar = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Max sum of continuous subarray if given array is "+ mcss.maxSubArraySum(ar));
    }

    int maxSubArraySum(int[] arr){
        int max_so_far = arr[0];
        int curr_max = arr[0];

        for (int i = 1; i < arr.length; i++)
        {
            curr_max = Math.max(arr[i], curr_max+arr[i]);
            max_so_far = Math.max(max_so_far, curr_max);
        }
        return max_so_far;
    }



}
