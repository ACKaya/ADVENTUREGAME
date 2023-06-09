import java.util.Scanner;

public class Player {
    private String playerName;
    private int damage;
    private int health;
    private int money;
    private int orjinalHeatlth;

    public Scanner scan=new Scanner(System.in);
    private Inventory inventory;


    public Player(String playerName) {
        this.playerName = playerName;
        this.inventory= new Inventory();

    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName =playerName;
    }

    public int getDamage() {

        return damage;
    }
    public void printplayerInfo(){
        System.out.println("*********************");
        System.out.println("Player GUN:"+getInventory().getWeapon().getName()+
                "\nPlayer Armor:"+getInventory().getArmor().getName()+
        "\nPlayer Damage:"+getDamage()+
                "\nPlayer Health: "+getHealth()+
                "\nPlayer Money: " + +getMoney());


    }


    public int totalHealth(){
        return this.getHealth()+(getInventory().getArmor().getDefence());
    }
    public int totalDamage(){
        return this.getDamage()+(getInventory().getWeapon().getDamage());
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getOrjinalHeatlth() {
        return orjinalHeatlth;
    }

    public void setOrjinalHeatlth(int orjinalHeatlth) {
        this.orjinalHeatlth = orjinalHeatlth;
    }

    public void selectChar(){
        Scanner scan=new Scanner(System.in);
        GameChar [] chars={new Samurai(),new Archer(),new Knight()};
        for(GameChar x:chars){
            System.out.println("ID-"+x.getID() +
                    "\t CHARACTER:"+x.getCharName()+
                    "\t CHARACTER HEALTH:"+x.getHealth()+
                    "\t CHARACTER DAMAGE:"+x.getDamage()+
                    "\t CHARACTER MONEY:"+x.getMoney());
        }
        System.out.print("CHOOSE YOUR CHARACTER:");
        int selected= scan.nextInt();
        switch (selected){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
        System.out.println(this.playerName);
    }
    public void initPlayer(GameChar character){
        setPlayerName(character.getCharName());
        setOrjinalHeatlth(character.getHealth());
        setDamage(character.getDamage());
        setHealth(character.getHealth());
        setMoney(character.getMoney());

    }
    public void selectWeapon(){
        Scanner scan=new Scanner(System.in);
        /*WEAPONS [] chars={new GLOCK(),new SWORD(),new RIFFLE()};
        for(WEAPONS x:chars){
            System.out.println("ID-"+x.getID() +
                    "\t WEAPON NAME:"+x.getName()+
                    "\t WEAPON  DAMAGE:"+x.getDamage()+
                    "\t WEAPON COST:"+x.getMoney());
        }
        System.out.print("CHOOSE YOUR WEAPON:");*/
        int selected= scan.nextInt();
        while(selected>3||selected<1){
            System.out.println("You Chose Invalid Number");
            System.out.println("Please Choose Again:");
            int selected2= scan.nextInt();
        }
        switch (selected){
            case 1:


                break;
            case 2:

                break;
            case 3:

                break;
            default:

        }
    }
    public void selectLoc() {
        while (true) {
            Location location = null;
            System.out.println("**********LOCATIONS*********");
            System.out.println("0-EXIT");
            System.out.println("1-Tool Store");
            System.out.println("2-Safe House");
            System.out.println("3-Cave");
            System.out.println("4-Forest");
            System.out.println("5-River");
            System.out.println("Choose a Location:");
            int selectLoc = scan.nextInt();
            switch (selectLoc) {
                case 0:
                    location=null;
                    System.out.println("The Game Has Finished");
                    break;

                case 1:
                    location = new ToolStore(this);
                    break;
                case 2:
                    System.out.println("YOU CAME TO THE SAFE HOUSE");
                    location = new SafeHouse(this);
                    break;
                case 3:
                    System.out.println("YOU CAME TO THE CAVE !!");
                    location=new Cave(this) ;
                    break;
                case 4:
                    System.out.println("YOU CAME TO THE FOREST!!");
                    location=new Forest(this);
                    break;
                case 5:
                    System.out.println("YOU CAME TO THE RIVER!!");
                    location=new River(this);
                    break;

                default:
                    location = new SafeHouse(this);
            }
            if(location==null){
                break;
            }

            location.onLocation();
            printplayerInfo();


        }
    }

}
