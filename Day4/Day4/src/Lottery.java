import java.util.HashMap;

public class Lottery {
    //Card 171: 27 58 57 48 76 97  1 86 25 40 | 36 32 61 74 82 31 38 79 33 34 46  2 27 89 50 10 22 55 72 91 39 64 43 98 42\n"
    String []cards;
    HashMap<Integer,Integer>numWinNums=new HashMap<Integer,Integer>();
    public Lottery(String input){
        cards=input.split("\n");

    }
    public int parseNumWinsPerGameNum(){
        String[]gameAndRest;
        for(int i=0;i< cards.length;i++){
            gameAndRest=cards[i].split(":");
            String[]keyAndCard;
            keyAndCard=gameAndRest[1].split("|");


        }
    }
}
