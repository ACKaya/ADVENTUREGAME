public class SafeHouse extends NormalLocation{
    public SafeHouse(Player player) {
        super("Safe House",player);
    }

    @Override
    public boolean onLocation() {
        this.getPlayer().setHealth(getPlayer().getOrjinalHeatlth());
        System.out.println("-YOUR HEALTH IS INCREASED TO THE "+getPlayer().getHealth());
        return true;
    }
}
