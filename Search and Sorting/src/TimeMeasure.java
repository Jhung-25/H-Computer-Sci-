import java.util.ArrayList;
import java.util.Random;

public class TimeMeasure {
    public static void main (String[]args){
        algoTester(20,1000);
        algoTester(20,5000);
        algoTester(20,10000);
        algoTester(20,50000);
        algoTester(20,100000);
        algoTester(20,500000);
        algoTester(20,1000000);
    }
    public static void algoTester(int numRuns,int size){
        //numRns = num of runs
        //size = size of each arrayList
        long totalTimeInsertion=0;
        long totalTimeSelection=0;
        long totalTimeMerge=0;


        for (int i = 0; i < numRuns; i++) {
            ArrayList<Integer> randomArrList = genRandomArrList(size);
            totalTimeInsertion += insertionSortTime(new ArrayList<>(randomArrList));
            totalTimeSelection += selectionSortTime(new ArrayList<>(randomArrList));
            totalTimeMerge+= mergeSortTime(new ArrayList<>(randomArrList));


        }
        long avgTimeInsertion = totalTimeInsertion / numRuns;
        long avgTimeSelection = totalTimeSelection / numRuns;
        long avgTimeMerge = totalTimeMerge / numRuns;


        System.out.println("Size"+ size+" avg insertsortTime: "+ avgTimeInsertion + "avg selctionsortTime: "+ avgTimeSelection+ " avg mergesortTime"+ avgTimeMerge);
    }
    public static ArrayList<Integer> genRandomArrList(int n) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr.add(rand.nextInt(Integer.MAX_VALUE));

        }
        return arr;
    }

    public static long insertionSortTime(ArrayList<Integer> arrList) {
        int temp;
        int newPlace;
        int numOfComp = 0;
        long startTime = System.currentTimeMillis();
        ;
        for (int i = 1; i < arrList.size(); i++) {
            temp = arrList.get(i);
            newPlace = i;
            while (newPlace > 0 && arrList.get(newPlace - 1) > temp) {
                numOfComp++;
                arrList.set(newPlace, arrList.get(newPlace - 1));
                newPlace--;
            }
            arrList.set(newPlace, temp);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static long selectionSortTime(ArrayList<Integer> arrList) {
        int indexOfLow;
        int placeHolder;
        int numOfComp = 0;
        long startTime = System.currentTimeMillis();

        for (int j = 0; j < arrList.size() - 1; j++) {
            indexOfLow = j;
            for (int i = j + 1; i < arrList.size(); i++) {
                numOfComp++;
                if (arrList.get(i) < arrList.get(indexOfLow)) {
                    indexOfLow = i;
                }
            }
            placeHolder = arrList.get(j);
            arrList.set(j, arrList.get(indexOfLow));
            arrList.set(indexOfLow, placeHolder);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
    public static long mergeSortTime(ArrayList<Integer> arr){
        long startTime = System.currentTimeMillis();
        ArrayList<Integer> sortedArr = mergeSort(arr);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
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
