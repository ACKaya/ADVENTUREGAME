public class Armors {
    private String name;
    private int ID;
    private int defence;
    private int money;

    public Armors(String name, int ID, int defence, int money) {
        this.name = name;
        this.ID = ID;
        this.defence = defence;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    public static Armors [] armors(){
        Armors []armor=new Armors[3];
        armor[0]=new LightArmor();
        armor [1]=new MiddleArmor();
        armor[2]=new HeavyArmor();
        return armor;
    }
    public static Armors getObjByID(int id){
        for(Armors armor:armors()){
            if(id==armor.getID()){
                return armor;
            }
        }
        return null;
    }
}
