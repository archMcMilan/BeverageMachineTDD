import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Created by Artem_Pryzhkov on 9/30/2016.
 */
public class Initializer {
    public static NavigableMap<Integer,Integer> initCoins(){
        NavigableMap<Integer,Integer> availableCoins=new TreeMap<>();
        availableCoins.put(1,5);
        availableCoins.put(5,10);
        availableCoins.put(10,15);
        availableCoins.put(25,20);
        availableCoins.put(50,25);
        return availableCoins;
    }

    public static Map<Product,Integer> initProducts(){
        Map<Product,Integer> availableProducts=new HashMap<>();
        availableProducts.put(Product.GREEN_TEA,4);
        availableProducts.put(Product.BLACK_TEA,2);
        availableProducts.put(Product.COFFEE,0);
        return availableProducts;
    }
}

