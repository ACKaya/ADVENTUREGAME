import java.util.Random;

public abstract class BattleLocation extends Location{
    private String award;
    private Monsters monster;
    private int maxMonster;

    public BattleLocation(String mapName, Player player, String award, Monsters monster,int maxMonster) {
        super(mapName, player);
        this.award = award;
        this.monster = monster;
        this.maxMonster=maxMonster;
    }

    @Override
    public boolean onLocation() {
        int monsterNumber=this.randomMonsterNumber();
        System.out.println("Welcome to the "+getMapName());
        System.out.println("If you kill the monster you can get "+getAward()    );
        System.out.println("Be carefull "+monsterNumber+" tane "+this.getMonster().getName()+" is living here!!");
        System.out.println("Do you want to fight with the "+this.getMonster().getName());
        System.out.println("Press <Y> to fight" +
                "Press <N> to escape");
        String selectCase= input.nextLine();
        selectCase=selectCase.toUpperCase();
        if(selectCase.equals("Y")){
            if(combat(monsterNumber)){
                System.out.println("Congratulations!!!!!");
                System.out.println("You have won the battle ");
                return true;
            }
        }
        if(getPlayer().totalHealth()<=0){
            System.out.println("You are dead!!");
            System.out.println("Game is over you lost!!!!");
            return false;
        }

        return true;
    }
    public boolean combat(int monsterNumber){
        for(int i=monsterNumber;0<i;i--){
            getMonster().setHealth(getMonster().getOrjinalHealth());
            printPlayerInfo();
            System.out.println(monsterNumber+". Monster Informations");
            System.out.println("********************");
            printMonsterInfo();
        while(getPlayer().totalHealth()>0&&getMonster().getHealth()>0) {
            System.out.println("<H>it or <E>scape");
            String selectCombatAction = input.nextLine().toUpperCase();
            if (selectCombatAction.equals("H")) {
                afterHitMonster();
                if (getMonster().getHealth() > 0) {
                    afterHitPlayer();
                }
            } else {
                return false;
            }

        }
        if(getPlayer().totalHealth()>getMonster().getHealth()){
            System.out.println("You killed the All Monster");
            System.out.println("You earned "+getMonster().getLoot()+" Money");
            this.getPlayer().setMoney(getPlayer().getMoney()+getMonster().getLoot());
            System.out.println("Your Total Money: "+getPlayer().getMoney());
        }
        monsterNumber--;

        }

        System.out.println("Fight is Over!!!");

        return true;
    }
    public void printPlayerInfo(){
        System.out.println("----------Player Informatıons--------");
        System.out.println("-------------------------------------------");
        System.out.println("Player Health: "+getPlayer().totalHealth());
        System.out.println("Player Damage: "+getPlayer().totalDamage());
        System.out.println("Player Weapon: "+getWeapon().getName());
        System.out.println("Player Armor: "+getArmor().getName());
        System.out.println("Player Damnage: "+getPlayer().totalDamage());
        System.out.println("Player Defence: "+getPlayer().totalHealth());
        System.out.println("Player Money: "+getPlayer().getMoney());
    }
    public void printMonsterInfo(){
        System.out.println(getMonster().getName()+" Informatinos");
        System.out.println("--------------------------------");
        System.out.println("Monster Health: "+getMonster().getHealth());
        System.out.println("Monster Damage: "+getMonster().getDamage());
    }
    public void afterHitPlayer(){
        System.out.println(getMonster().getName()+" hitted to you ");
        getPlayer().setHealth(getPlayer().totalHealth()-getMonster().getDamage());
        System.out.println("Your Remaining Health: "+getPlayer().getHealth());
    }
    public void afterHitMonster(){
        System.out.println("You hitted to "+getMonster().getName());
        getMonster().setHealth(getMonster().getHealth()-getPlayer().totalDamage());
        System.out.println("Monster's Remaining Health: "+getMonster().getHealth() );
    }
   public int randomMonsterNumber(){
        Random r=new Random();
        return r.nextInt(this.getMaxMonster())+1;
   }
    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public Monsters getMonster() {
        return monster;
    }

    public void setMonster(Monsters monster) {
        this.monster = monster;
    }

    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }
    public WEAPONS getWeapon(){
        return getPlayer().getInventory().getWeapon();
    }
    public Armors getArmor(){
        return getPlayer().getInventory().getArmor();
    }
}
