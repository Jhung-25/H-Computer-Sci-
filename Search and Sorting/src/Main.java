import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        int[] sortArr= new int[ ]{3,4,6,2,1,9};
        System.out.println(sequentialSearch(4, arr));
        System.out.println(binarySearch(6,arr));
        System.out.println(selectionSort(sortArr));
    }

    public static int sequentialSearch(int tarNum, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == tarNum) {
                return i;
            }
        }

        return -1;
    }

    public static int binarySearch(int tarNum, int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int midPoint = 0;

        while (start <= end) {
            midPoint=start+(end-start) /2;
            if(arr[midPoint]==tarNum){
                return midPoint;

            }
            if (arr[midPoint]<tarNum) {
                start=midPoint+1;
            }
            else{
                end=midPoint-1;
            }

        }
        return -1;

    }
    public static int[] insertionSort(int[]arr){

        return null;
    }
    public static int[] selectionSort(int[] arr){













        int low=arr[0];
        int indexOfLow=0;
        int placeHolder=0;
         for(int j=0;j<arr.length;j++) {

             for (int i = j; i < arr.length; i++) {
                 if (arr[i] < low) {
                     low = arr[i];
                     indexOfLow = i;

                 }


             }
             arr[indexOfLow]=arr[j];
             arr[j]=low;
         }
        return arr;



//        int lowest=arr[0];
//        int place=0;
//        int indexOfLow=0;
//        for(int i =0;i<arr.length;i++){
//            if(arr[i]<lowest){
//                indexOfLow=i;
//                lowest=arr[i];
//            }
//        }
    }


}