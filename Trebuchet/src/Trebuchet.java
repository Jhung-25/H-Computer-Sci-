public class Trebuchet {
    String[] arr;

    public Trebuchet(String input) {
        arr = input.split("\n", 0);
    }
    private String wordToNumber(String word) {
        switch (word.toLowerCase()) {
            case "one":
                return "1";
            case "two":
                return "2";
            case "three":
                return "3";
            case "four":
                return "4";
            case "five":
                return "5";
            case "six":
                return "6";
            case "seven":
                return "7";
            case "eight":
                return "8";
            case "nine":
                return "9";
            default:
                    return "0";
        }
    }

    public int outputCalc() {
        int total = 0;
        for (String line : arr) {
            String firstDigit = null;
            String secondDigit = null;
            String firstSpelledDigit= null;
            String secondSpelledDigit = null;
            int indexFDig=0;
            int startIndexofSpelled1Dig=line.length();
            int startIndexofSpelled2Dig=-1;
            int indexSDig=0;
            //finding the first digit not spelled out
            for (int i = 0; i < line.length(); i++) {
                if (Character.isDigit(line.charAt(i))) {
                    firstDigit = String.valueOf(line.charAt(i));
                    indexFDig=i;
                    break;
                }
            }

            for (int i = line.length() - 1; i >= 0; i--) {
                if (Character.isDigit(line.charAt(i))) {
                    secondDigit = String.valueOf(line.charAt(i));
                    indexSDig=i;
                    break;
                }
            }
            String[] numberWords = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
            int[] numberValues = {1, 2, 3, 4, 5, 6, 7, 8, 9};
            for (int i = 0; i < numberWords.length; i++) {
                int wordIndex = line.indexOf(numberWords[i]);
                int lastWordIndex= line.lastIndexOf(numberWords[i]);
                if (wordIndex >= 0 && wordIndex < startIndexofSpelled1Dig) {
                    startIndexofSpelled1Dig = wordIndex;
                    firstSpelledDigit = numberWords[i];
                }

                if (lastWordIndex >= 0 && lastWordIndex > startIndexofSpelled2Dig) {
                    startIndexofSpelled2Dig = lastWordIndex;
                    secondSpelledDigit = numberWords[i];
                }
            }
            if(firstSpelledDigit!=null) {
                firstSpelledDigit = wordToNumber(firstSpelledDigit);
            }
            if(secondSpelledDigit!=null){
                secondSpelledDigit = wordToNumber(secondSpelledDigit);
            }

            if(indexFDig>startIndexofSpelled1Dig){
                firstDigit=firstSpelledDigit;
            }
            if(indexSDig<startIndexofSpelled2Dig){
                secondDigit=secondSpelledDigit;
            }
            if (firstDigit != null && secondDigit != null) {
                String combinedDigits = firstDigit + secondDigit;
                System.out.println("string= "+line+" First Dig: "+firstDigit+ "second Dig: "+ secondDigit+ " Combined Digs: "+ combinedDigits);

                try {
                    total += Integer.parseInt(combinedDigits);
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing number: " + combinedDigits + "line num:"+line);
                }
            }
        }
        return total;
    }
}
