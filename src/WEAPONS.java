public class WEAPONS {
    private String name;
    private int ID;
    private int damage;
    private int money;

    public WEAPONS(String name, int ID, int damage, int money) {
        this.name = name;
        this.ID = ID;
        this.damage = damage;
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

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    public static WEAPONS [] weapons(){
        WEAPONS [] weaponList=new WEAPONS[3];
        weaponList[0]=new GLOCK();
        weaponList[1]=new SWORD();
        weaponList[2]=new RIFFLE();
        return weaponList;
    }
    public static WEAPONS getObjById(int id){
        for(WEAPONS w:weapons()){
            if(id==w.getID()){
                return w;
            }
        }
        return null;
    }
}

