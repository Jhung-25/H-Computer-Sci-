import java.util.HashMap;
import java.io.*;
import java.util.*;
public class Lottery {
    //Card 171: 27 58 57 48 76 97  1 86 25 40 | 36 32 61 74 82 31 38 79 33 34 46  2 27 89 50 10 22 55 72 91 39 64 43 98 42\n"
    String []cards;
    public HashMap<Integer,Integer>numWinNums=new HashMap<Integer,Integer>();
//    private HashMap<Integer,HashMap<Integer,Integer>>numCards=new HashMap<Integer,HashMap<Integer,Integer>>();
    private HashMap<Integer,Integer>numCards=new HashMap<Integer,Integer>();
    public Lottery(String input){
        cards=input.split("\n");
        parseNumWinsPerGameNum();
        findNumCards();
    }
//    public int getTotalScore(){
//        int sum=0;
//        for(int i=1;i<=numWinNums.size();i++){
//
//                sum+=Math.pow(2,numWinNums.get(i)-1);
//
//        }
//        return sum;
//    }


public void parseNumWinsPerGameNum() {
    for (int i = 0; i < cards.length; i++) {
        String[] parts = cards[i].split(":");
        String[] keyStrings = parts[1].split("\\|")[0].trim().split("\\s+");
        String[] gameStrings = parts[1].split("\\|")[1].trim().split("\\s+");

        HashSet<Integer> keySet = new HashSet<>();
        for (String s : keyStrings) {
            keySet.add(Integer.parseInt(s));
        }

        HashSet<Integer> gameSet = new HashSet<>();
        for (String s : gameStrings) {
            gameSet.add(Integer.parseInt(s));
        }

        keySet.retainAll(gameSet);
        numWinNums.put(i + 1, keySet.size());
    }
}
    public void findNumCards(){
//        for(int i=1;i<=100;i++){//set each card to have one each
//            numCards.put(i,1);
//        }
//        for(int i=1;i<=100;i++){
//            for(int j=1;j<=numCards.get(i);j++){
//                for(int k =i+1;k<=numWinNums.get(i)+i;k++){
//                    numCards.put(k,numCards.get(i)+1);
//                    System.out.println("Cards: "+ i +"Num Cards: "+ j +" Num Wins per card:"+numWinNums.get(i));
//                }
//            }
//        }
        for (int i = 1; i <= numWinNums.size(); i++) {
            numCards.put(i, 1);
        }

        // Iterate through each card
        for (int i = 1; i <= numWinNums.size(); i++) {
            int matches = numWinNums.get(i); //num each card num wins

            // For each copy of the current card
            for (int j = 0; j < numCards.get(i); j++) {
                // gen copies
                for (int k = i + 1; k <= i+matches; k++) {
                    numCards.put(k, numCards.get(k) + 1);
                    System.out.println("Num Wins: "+matches +" cur card "+ i);
                }
            }
        }
    }


    public int findTotalCardAdded(){
        int sum=0;
        for(int i=1;i<=numCards.size();i++){
            sum+=numCards.get(i);
        }
        return sum;
    }
}
