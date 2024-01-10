import java.util.HashMap;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Day6 {
    public static void main(String[] Args) {
        String input = "Time:        46     80     78     66\n" +
                "Distance:   214   1177   1402   1024";

        ArrayList<String> test = new ArrayList<String>(arrayMaker(input));
        System.out.println(day6(test));

    }
    public static ArrayList<String> arrayMaker(String starter) {
        ArrayList<String> inputArray = new ArrayList<String>();
        String temp = "";
        for (int i = 0; i < starter.length(); i++) {
            if (starter.charAt(i) != '\n') {
                temp += starter.charAt(i);
                if (i == starter.length() - 1) {
                    inputArray.add(temp);
                }

            } else {
                inputArray.add(temp);
                temp = "";
            }
        }
        return inputArray;
    }

    public static int day6(ArrayList<String>array) {
        ArrayList<Integer> time = new ArrayList<>();
        ArrayList<Integer> distance = new ArrayList<>();
        int total = 1;
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(array.get(0));
        Matcher matcher1 = pattern.matcher(array.get(1));
        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group());
            time.add(number);
        }
        while (matcher1.find()) {
            int number = Integer.parseInt(matcher1.group());
            distance.add(number);
        }
        for (int n = 0; n < time.size(); n++) {
            int time1 = time.get(n);
            int distance1 = distance.get(n);
            int roundScore = 0;
            for (int z = 0; z < time1; z++) {
                int charge = z;
                int toTravel = time1 - z;
                if ((charge * toTravel) > distance1) {
                    roundScore += 1;
                }
            }
            total *= roundScore;

        }
        return total;
    }
}