import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        int[] sortArr= new int[ ]{3,4,6,2,1,9};
        int[] testArr2=new int[]{3,4,6,2,1,9};

        System.out.println(sequentialSearch(4, arr));
        System.out.println(binarySearch(6,arr));
//        int[] newArr=new int[sortArr.length];
        int[] testArr=new int[testArr2.length];
//        newArr=insertionSort(sortArr);
        testArr=selectionSort(testArr2);
//        for(int i=0;i<newArr.length;i++){
//            System.out.print(newArr[i]);
//
//        }
        System.out.println();
        for(int i=0;i<testArr.length;i++){

            System.out.print(testArr[i]);
        }
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
        int temp=arr[0];
        int newPlace=0;
        int switchIndex;
        int oldNum=0;
        for(int i=0;i<arr.length-1;i++){
            temp=arr[i+1];
            for(int j=i+1;j>0;j--){

                if(temp<arr[j-1]){
                    newPlace=j-1;
                    oldNum=arr[j-1];


                }
                else{
                    break;
                }
            }

            arr[newPlace]=temp;
            arr[i]=oldNum;
        }
        return arr;
    }
    public static int[] selectionSort(int[] arr){














        int indexOfLow=0;
        int placeHolder=0;
        int newBounds=arr.length;

         for(int j=0;j<newBounds-1;j++) {
            indexOfLow=j;
             for (int i = j+1; i < arr.length; i++) {
                 if (arr[i] < arr[indexOfLow]) {
                     indexOfLow = i;

                 }


             }
             placeHolder=arr[j];
             arr[j]=arr[indexOfLow];
             arr[indexOfLow]=placeHolder;
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
    public static ArrayList<Integer> mergeSort(ArrayList<Integer> arr){
        if(arr.size()==0||arr.size()==1){
            return arr;
        }
        mergeSort(arr.subList(0,(arr.size()/2)-1));
    }


}