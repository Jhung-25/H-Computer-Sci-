import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
public class TesterClass {
    public static void main (String[]args){
//        for(int i=0;i<1000;i+=100) {
//            algoTester(5, i);
//        }
        ArrayList<Integer> arr= new ArrayList<Integer>(Arrays.asList(50,20,1,60,42,34,532,53,23,23));

        selectionSortCompNum(arr);
    }
    public static void algoTester(int numRuns,int size){
        //numRns = num of runs
        //size = size of each arrayList
        int totalCompsInsertion=0;
        int totalCompsSelection=0;


        for (int i = 0; i < numRuns; i++) {
            ArrayList<Integer> randomArrList = genRandomArrList(size);
            totalCompsInsertion += insertionSortCompNum(new ArrayList<>(randomArrList));
            totalCompsSelection += selectionSortCompNum(new ArrayList<>(randomArrList));
        }

        double avgCompsInsertion = (double) totalCompsInsertion / numRuns;
        double avgCompsSelection = (double) totalCompsSelection / numRuns;
        System.out.println("Size:"+ size + "avg comps Insertion"+ " = "+ avgCompsInsertion+ " Size:"+ size + "avg comps Selection"+ " = " + avgCompsSelection);
    }
    public static ArrayList<Integer> genRandomArrList(int n){
        ArrayList<Integer>arr =new ArrayList<Integer>();
        Random rand = new Random();
        for(int i=0;i<n;i++){
            arr.add(rand.nextInt(Integer.MAX_VALUE));

        }
        return arr;
    }
    public static long insertionSortCompNum(ArrayList<Integer> arrList) {
        int temp;
        int newPlace;
        long numOfComp=0;
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
        return numOfComp;
    }
    public static long selectionSortCompNum(ArrayList<Integer> arrList) {
        int indexOfLow;
        int placeHolder;
        long numOfComp=0;
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
        System.out.println(arrList.toString());

        return numOfComp;
    }
}
