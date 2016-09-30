import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Created by Artem_Pryzhkov on 9/30/2016.
 */
public class BeverageMachine {
    private Map<Product,Integer> products;
    private Map<Integer,Integer> availableCoins;
    private int currentInputValue;

    public BeverageMachine() {
        this.products = new HashMap<>();
        this.availableCoins=Initializer.init();
    }

    public boolean add(Product product){
        try{
            products.merge(product,1,Integer::sum);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean add(Product product,int amount){
        try{
            products.merge(product,amount,Integer::sum);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public boolean giveProduct(Product product) {
        Integer productAmount= products.get(product);
        if(productAmount!=null && productAmount>0){
            productAmount--;
            products.put(product,productAmount);
            return true;
        }
        return false;
    }

    public boolean addCoin(int value) {
        if(availableCoins.get(value)==null){
            return false;
        }
        availableCoins.merge(value,1,Integer::sum);
        currentInputValue+=value;
        return true;
    }


    public int getCurrentInputValue() {
        return currentInputValue;
    }


    public boolean buyProduct(Product product) {
        if(!products.containsKey(product) || !isEnoughValueInput(product)){
            return false;
        }
        return true;
    }

    private boolean isEnoughValueInput(Product product){
        if(product.getPrice()<=currentInputValue){
            return true;
        }
        return false;
    }
}
