import java.util.*;

/**
 * Created by Artem_Pryzhkov on 9/30/2016.
 */
public class BeverageMachine {
    private Map<Product,Integer> availableProducts;
    private NavigableMap<Integer,Integer> availableCoins;
    private int currentInputValue;
    private Product currentProduct;

    public BeverageMachine() {
        this.availableProducts = Initializer.initProducts();
        this.availableCoins=Initializer.initCoins();
    }

    public boolean add(Product product){
        try{
            //availableProducts.merge(product,1,Integer::sum);
            currentProduct=product;
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean giveProduct() {
        Integer productAmount= availableProducts.get(currentProduct);
        if(productAmount!=null && productAmount>0){
            productAmount--;
            availableProducts.put(currentProduct,productAmount);
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


    public boolean buyProduct() {
        if(buyConditions()){
            return false;
        }
        return true;
    }

    private boolean buyConditions() {
        return !availableProducts.containsKey(currentProduct) || !isEnoughValueInput() || !giveProduct();
    }

    private boolean isEnoughValueInput(){
        if(currentProduct.getPrice()<=currentInputValue){
            return true;
        }
        return false;
    }

    public boolean isChangeAvailable(int value,NavigableMap<Integer,Integer> outputCoins){
        for(Integer coinValue:availableCoins.descendingKeySet()){
            int coinsAmount=value/coinValue;
            int availableCoinsAmount=availableCoins.get(coinValue);
            value = balanceValue(value, outputCoins, coinValue, coinsAmount, availableCoinsAmount);
        }
        if(value==0)
            return true;
        else
            return false;
    }

    private int balanceValue(int value, NavigableMap<Integer, Integer> outputCoins, Integer coinValue, int coinsAmount,
                             int availableCoinsAmount) {
        if(availableCoinsAmount>=coinsAmount){
            value-=coinsAmount*coinValue;
            outputCoins.put(coinValue,coinsAmount);
        }else{
            value-=availableCoinsAmount*coinValue;
            outputCoins.put(coinValue,availableCoinsAmount);
        }
        return value;
    }
    public NavigableMap<Integer,Integer> getChange(){
        NavigableMap<Integer,Integer> outputCoins=new TreeMap<>();
        if(isChangeAvailable(currentInputValue,outputCoins)){
            for(Integer coinValue:availableCoins.descendingKeySet()){
                availableCoins.merge(coinValue,outputCoins.get(coinValue)*(-1),Integer::sum);
            }
            return outputCoins;
        }
        return null;
    }
}
