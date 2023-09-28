import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {

    }


    public static int sequentialSearch(int tarNum, ArrayList<Integer> arrList) {
        for (int i = 0; i < arrList.size(); i++) {
            if (arrList.get(i) == tarNum) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int tarNum, ArrayList<Integer> arrList) {
        int start = 0;
        int end = arrList.size() - 1;
        int midPoint = 0;

        while (start <= end) {
            midPoint = start + (end - start) / 2;
            if (arrList.get(midPoint) == tarNum) {
                return midPoint;
            }
            if (arrList.get(midPoint) < tarNum) {
                start = midPoint + 1;
            } else {
                end = midPoint - 1;
            }
        }
        return -1;
    }

    public static ArrayList<Integer> insertionSort(ArrayList<Integer> arrList) {
        int temp;
        int newPlace;
        for (int i = 1; i < arrList.size(); i++) {
            temp = arrList.get(i);
            newPlace = i;
            while (newPlace > 0 && arrList.get(newPlace - 1) > temp) {
                arrList.set(newPlace, arrList.get(newPlace - 1));
                newPlace--;
            }
            arrList.set(newPlace, temp);
        }
        return arrList;
    }


    public static ArrayList<Integer> selectionSort(ArrayList<Integer> arrList) {
        int indexOfLow;
        int placeHolder;
        for (int j = 0; j < arrList.size() - 1; j++) {
            indexOfLow = j;
            for (int i = j + 1; i < arrList.size(); i++) {
                if (arrList.get(i) < arrList.get(indexOfLow)) {
                    indexOfLow = i;
                }
            }
            placeHolder = arrList.get(j);
            arrList.set(j, arrList.get(indexOfLow));
            arrList.set(indexOfLow, placeHolder);
        }
        return arrList;
    }

    public static ArrayList<Integer> mergeSort(ArrayList<Integer> arr){

        if(arr.size()==0||arr.size()==1){
            return arr;
        }
        ArrayList<Integer> returnArr=new ArrayList<Integer>();
        ArrayList<Integer> left=new ArrayList<Integer>(arr.subList(0,arr.size()/2));
        ArrayList<Integer> right= new ArrayList<Integer>(arr.subList(arr.size()/2,arr.size()));
        left= mergeSort(left);
        right=mergeSort(right);



        return merge(left,right);
    }
    private static ArrayList<Integer> merge(ArrayList<Integer>left,ArrayList<Integer>right){
        ArrayList<Integer>returnList=new ArrayList<Integer>();
        int leftIndex = 0, rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex) <= right.get(rightIndex)) {
                returnList.add(left.get(leftIndex));
                leftIndex++;
            } else {
                returnList.add(right.get(rightIndex));
                rightIndex++;
            }
        }

        while (leftIndex < left.size()) {
            returnList.add(left.get(leftIndex));
            leftIndex++;
        }

        while (rightIndex < right.size()) {
            returnList.add(right.get(rightIndex));
            rightIndex++;
        }

        return returnList;
    }


}