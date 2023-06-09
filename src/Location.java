import java.util.Scanner;

public abstract class Location {
    private String mapName;
    private Player player;
    public Scanner input=new Scanner(System.in);

    public Location(String mapName, Player player) {
        this.mapName = mapName;
        this.player = player;
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    public abstract boolean onLocation();


}
