import java.util.Scanner;

public  abstract class NormalLocation extends Location{
    public NormalLocation( String mapName,Player player) {
        super(mapName, player);
    }

    @Override
    public boolean onLocation() {


        return true;
    }
}
