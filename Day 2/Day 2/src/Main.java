
public class Main {
    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        // Press Ctrl+R or click the green arrow button in the gutter to run the code.
//        Cubes test = new Cubes(testinput);
//        test.declareMap();
////        test.printhashVal();

        Cubes cube= new Cubes(input);
        cube.declareMap();
        System.out.println(cube.findSumGameNonInvalid());
        System.out.println(cube.findPowerOfSet());
    }
}