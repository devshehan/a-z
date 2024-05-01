import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] numberArray = {12, 23, 11, 6, 90, 1, 76};
         findTheLargestNumberInTheArray(numberArray);
         checkTheArrayIsSorted(numberArray);
         secondLargestElementInTheArray(numberArray);
         secondSmallestElementInTheArray(numberArray);
         linearSearch(numberArray,1);
         leftRotateByOne(numberArray);
    }

    public static void findTheLargestNumberInTheArray(int[] numberArr){

        // brute force solution
        // time complexity -> O(n log n)
//        Arrays.sort(numberArr);
//        int largestNumber = numberArr[numberArr.length-1];
//        System.out.println("Method 1: " + largestNumber );

        // Optimal Solution
//          Time complexity -> O(log n)
        int largestNum = numberArr[0];
        for(int i : numberArr){
            if(i > largestNum){
                largestNum = i;
            }
        }
        System.out.println("Method 2: " + largestNum);
    }

    public static void checkTheArrayIsSorted(int[] numberArr){

        // Brute force solution O(n log n)
//        int[] newArray = new int[numberArr.length];
//        System.arraycopy(numberArr, 0, newArray, 0, numberArr.length);
//
//        Arrays.sort(numberArr);
//        boolean isSortedM1 = Arrays.equals(numberArr, newArray);
//        System.out.println("Is array is sorted: " + isSortedM1);

        // Optimal solution O(n)
        boolean isSorted = true;
        int tempHolder = numberArr[0];
        for(int i : numberArr){
            if ( i < tempHolder){
                isSorted = false;
                break;
            }else{
                tempHolder = i;
            }
        }

        System.out.println("Is array is sorted: " + isSorted);
    }

    public static void secondLargestElementInTheArray(int[] numberArr){

        int largest = numberArr[0];
        int secondLargest = Integer.MIN_VALUE;

        for(int i = 0; i < numberArr.length; i++ ){
            if(numberArr[i] > largest){
                secondLargest = largest;
                largest = numberArr[i];
            }else if(numberArr[i] < largest && numberArr[i] > secondLargest){
                secondLargest = numberArr[i];
            }
        }

        System.out.println("Second largest element in the array: " + secondLargest);
    }

    public static void secondSmallestElementInTheArray(int[] arr){

        int smallest = arr[0];
        int secondSmallest = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] < smallest){
                secondSmallest = smallest;
                smallest = arr[i];
            }else if ( arr[i] < smallest && arr[i] > smallest){
                secondSmallest = arr[i];
            }
        }

        System.out.println("Second smallest is: " + secondSmallest);
    }

    public static void linearSearch(int[] arr, int t){
        int index = -1;
        for(int i = 0; i < arr.length; i++ ){
            if(arr[i] == t){
                index = i;
                break;
            }
        }
        System.out.println("Linear search of value: " + index );
    }

    public static void leftRotateByOne(int[] arr){

        int temp = arr[0];
        for(int i=1; i < arr.length; i++){
            arr[i-1] = arr[i];
        }
        arr[arr.length-1]  = temp;

        System.out.println("After the rotate: " + Arrays.toString(arr));
    }
}