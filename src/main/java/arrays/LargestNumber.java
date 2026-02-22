package arrays;

import java.util.Arrays;

public class LargestNumber {

    private static int getLargestNum(int[] n){

        int largest = n[0];
        int secLargest= n[1];

       /* for (int i =0; i<n.length;i++){
            if(n[i]>largest){
                largest=n[i];
            }*/
            for (int j : n) {
                if (j > largest) {
                    largest = j;

                }
        }
        return largest;
    }

    private static int secLargest(int[] n){

        int largest = n[0];
        int secLargest =-1;

        for (int j : n) {
            if (j > largest) {
                secLargest=largest;
                largest = j;

            }
            else if (j<largest && j>secLargest){
                secLargest=j;
            }
        }
        /*for (int i : n) {
            if (i > secLargest && i!= largest) {
                secLargest = i;
            }
        }*/
        return secLargest;
    }

    private static int secSmallest(int[] n){
        int smallest= n[0];
        int secSmallest = 0;

        for (int j:n){
            if(j<smallest){
                secSmallest=smallest;
                smallest=j;
            }
            else if (j<secSmallest && j!=smallest){
                secSmallest=j;
            }
        }
        return secSmallest;
    }
    private static int secSmallestByStream(int[] n){
        return Arrays.stream(n).distinct().sorted().skip(1).findFirst().orElse(-1);
    }

    public static void main(String[] args) {
        int[] n = {3,2,5,6,6,1};
        int[] nn = {1,3,5,6};
        System.out.println(getLargestNum(n));
        System.out.println(secLargest(n));
        System.out.println(secSmallest(n));

        System.out.println("===By Stream==");
        System.out.println(secLargest(n));
        System.out.println(removeElement(n,6));
        System.out.println(searchInsert(nn,2));
    }
    public static int removeElement(int[] nums, int val) {

        int index=0;
        for (int num : nums) {
            if (num != val) {
                nums[index]=num;
                index++;
            }
        }

        return index;
        //return Math.toIntExact(Arrays.stream(newArray).count());
    }
    public static int searchInsert(int[] nums, int target) {

        if(nums[nums.length-1]<target){
            return nums.length-1;
        }
        for(int i=0; i<nums.length;i++){
            if(nums[i]==target){
                return i;
            }
            else if(nums[i]<target && nums[i+1]>target){
                return i+1;
            }
        };
      return 0;
    }
}
