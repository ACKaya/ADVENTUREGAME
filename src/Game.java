import java.util.Scanner;

public class Game {
    Scanner scan=new Scanner(System.in);
    public void start(){
    System.out.println("WELCOME TO THE ADVENTURE GAME :) ");
    System.out.println("IN HERE THE EVERY THING YOU ARE GOING TO SEE ARE REAL!!!");
    System.out.print("Please Enter Your Name:");
    String playerName= scan.nextLine();
    System.out.println("GET READY "+playerName+" THE GAME HAS STARTED YET ");
    System.out.println("-------------------------");
    Player p=new Player("Anil");
    p.selectChar();

        p.selectLoc();









    }


}
