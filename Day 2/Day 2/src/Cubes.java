import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class Cubes {
    String arr[];//arr of each full game

    HashMap<Integer,HashMap<String,Integer>> innerMap=new HashMap<Integer,HashMap<String,Integer>>();
    public Cubes(String input){
        this.arr=input.split("\n");

    }
    public void declareMap(){
        int totalGameCount=0;
        for(int i=0; i<arr.length;i++){
            String[]gametoGames=arr[i].split(":");
            String[] gamestorounds = gametoGames[1].split(";");
            parseGreatestNumColor(i+1,gamestorounds);
//            for(int k=0;k<gameRound.length;k++) {
//            }

        }
    }
    public int findSumGameNonInvalid(){
        //12 red cubes, 13 green cubes, and 14 blue cubes is max
//        boolean isGameValid=true;
//        while
        int sumOfValid=0;
        for(int i=1;i<=100;i++){
            if(innerMap.get(i).get("blue")<=14&&innerMap.get(i).get("red")<=12&&innerMap.get(i).get("green")<=13){
                sumOfValid+=i;
            }
        }
        return sumOfValid;
    }
    public int findPowerOfSet(){
        int powerSum=0;

        for(int i=1;i<=100;i++){
            int green= innerMap.get(i).get("green");
            int blue= innerMap.get(i).get("blue");
            int red= innerMap.get(i).get("red");
            int gamePower=red*blue*green;
            powerSum+=gamePower;
        }
        return powerSum;
    }
    public void printhashVal(){
        System.out.println(innerMap.get(1).get("blue"));
    }
    private void parseGreatestNumColor(int gamenum,String[]rounds){
        int maxRed=0;
        int maxGreen=0;
        int maxBlue=0;
        HashMap<String,Integer>colorNum=new HashMap<String,Integer>();

        for(int i=0;i<rounds.length;i++){
            String[]colors=rounds[i].split(",");

            for(int k=0;k<colors.length;k++){
                String place=colors[k];
                String num="";
                String color=null;
                int valNum=0;

                for(int j=0;j<place.length();j++){//find the number value of the color and color
                    if(Character.isDigit(place.charAt(j))){
                        num+=place.charAt(j);
                    }
                    if(place.charAt(j)=='g'){
                        color="green";
                        break;
                    }
                    if(place.charAt(j)=='r'){
                        color="red";
                        break;
                    }
                    if(place.charAt(j)=='b'){
                        color="blue";
                        break;
                    }
                }
                //find the color
                valNum=Integer.parseInt(num);
                if(color.equals("blue")&&valNum>maxBlue){
                    maxBlue=valNum;
                }
                if(color.equals("green")&&valNum>maxGreen){
                    maxGreen=valNum;
                }
                if(color.equals("red")&&valNum>maxRed){
                    maxRed=valNum;
                }

            }

        }
        colorNum.put("red",maxRed);
        colorNum.put("blue",maxBlue);
        colorNum.put("green",maxGreen);
        innerMap.put(gamenum,colorNum);
    }
}
