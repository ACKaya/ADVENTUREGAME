public class Monsters {
    private int id;
    private int damage;
    private int health;
    private String name;
    private int loot;
    private int orjinalHealth;


    public Monsters(int id, int damage, int health, String name,int loot) {
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.name = name;
        this.loot=loot;
        this.orjinalHealth=health;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if(health<0){
            health=0;
        }
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLoot() {
        return loot;
    }

    public void setLoot(int loot) {
        this.loot = loot;
    }

    public int getOrjinalHealth() {
        return orjinalHealth;
    }

    public void setOrjinalHealth(int orjinalHealth) {
        this.orjinalHealth = orjinalHealth;
    }

}
