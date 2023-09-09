
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 4, 5, 6};
//        System.out.println(sequentialSearch(4, arr));
        System.out.println(binarySearch(6,arr));
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
        int midPoint = start+end/2;

        while (start <= end) {
            midPoint=(start+end)/2;
            if(midPoint==tarNum){
                return midPoint-1;

            }
            if (arr[midPoint]>tarNum) {
                end=midPoint-1;
            }
            else{
                start=midPoint+1;
            }

        }
        return -1;

    }
}