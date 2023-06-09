public class Inventory {
    private WEAPONS weapon;
    private Armors armor;

    public Inventory() {

        this.weapon = new WEAPONS("PUNCH",0,0,0);
        this.armor=new Armors("NAKED",0,0,0);
    }

    public WEAPONS getWeapon() {
        return weapon;
    }

    public void setWeapon(WEAPONS weapon) {
        this.weapon = weapon;
    }

    public Armors getArmor() {
        return armor;
    }

    public void setArmor(Armors armor) {
        this.armor = armor;
    }
}
