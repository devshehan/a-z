import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");

        int[] arr = {1,1,1,1,0,1,1,0,0,0,1,1,1,1,1,0,0,0,0,1,1,1};
        int[] arr1 = {5,6,7,8,9,10,11};
        int[] arr2 = {1 ,2, 3, 4, 5, 6, 7, 8, 9};

        maximumConsecutiveOnes(arr);
        moveZerosToTheEnd(arr);
        leftRotateByDElements(arr2,90);
        sortedUnionArray(arr1,arr2);
    }

    public static void maximumConsecutiveOnes(int[] arr){

        int count = 0;
        int maxConOnes = 0;

        // O(n)
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 1){
                count++;
                if(count > maxConOnes){
                    maxConOnes = count;
                }
            }else{
                count = 0;
            }
        }

        System.out.println("Max consecutive ones is : " + maxConOnes);
    }

    public static void moveZerosToTheEnd(int[] arr){

        int j = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                j = i;
                break;
            }
        }

        for(int i = j+1; i < arr.length; i++){

            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }

        System.out.println("Move zeros to the end: " + Arrays.toString(arr));
    }

    public static void leftRotateByDElements(int[] arr, int dElement){

        int d = dElement % arr.length;
        int n = arr.length;

        int[] temArr = new int[d];
        for(int i=0; i < d; i++){
            temArr[i] = arr[i];
        }

        for(int i = d; i < n; i++){
            arr[i-d] = arr[i];
        }

        int k = n-d;
        for(int i = k; i < n; i++){
            arr[i] = temArr[i-(n-d)];
        }

        System.out.println("Shifted by: " + dElement + " : " + Arrays.toString(arr));
    }

    public static void sortedUnionArray(int[] a, int[] b){
        Set<Integer> set = new LinkedHashSet<>();

        int n1 = a.length;
        int n2 = b.length;
        int i = 0;
        int j = 0;

        while(i<n1 && j<n2){
            if(a[i] < b[j]){
                if(set.isEmpty() || !set.contains(a[i])){
                    set.add(a[i]);
                }
                i++;
            }else{
                if(set.isEmpty() || !set.contains(b[j])){
                    set.add(b[j]);
                }
                j++;
            }
        }

        while(i<n1){
            if(set.isEmpty() || !set.contains(a[i])){
                set.add(a[i]);
            }
            i++;
        }

        while(j<n2){
            if(set.isEmpty() || !set.contains(b[j])){
                set.add(b[j]);
            }
            j++;
        }

        System.out.println("Union Array: " + set);
    }

}











