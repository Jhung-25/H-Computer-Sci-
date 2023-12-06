public class Trebuchet {
    String[] arr;

    public Trebuchet(String input) {
        arr = input.split("\n", 0);
    }

    public int outputCalc() {
        int total = 0;
        for (String line : arr) {
            String firstDigit = null;
            String secondDigit = null;

            for (int i = 0; i < line.length(); i++) {
                if (Character.isDigit(line.charAt(i))) {
                    firstDigit = String.valueOf(line.charAt(i));
                    break;
                }
            }

]            for (int i = line.length() - 1; i >= 0; i--) {
                if (Character.isDigit(line.charAt(i))) {
                    secondDigit = String.valueOf(line.charAt(i));
                    break;
                }
            }

            if (firstDigit != null && secondDigit != null) {
                String combinedDigits = firstDigit + secondDigit;
                try {
                    total += Integer.parseInt(combinedDigits);
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing number: " + combinedDigits);
                }
            }
        }
        return total;
    }
}
