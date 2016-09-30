import java.util.HashMap;
import java.util.Map;

/**
 * Created by Artem_Pryzhkov on 9/30/2016.
 */
public class Initializer {
    public static Map<Integer,Integer> init(){
        Map<Integer,Integer> availableCoins=new HashMap<>();
        availableCoins.put(1,5);
        availableCoins.put(5,10);
        availableCoins.put(10,15);
        availableCoins.put(25,20);
        availableCoins.put(50,25);
        return availableCoins;
    }
}
