import org.junit.*;

public class PosTest {
    BeverageMachine machine;

    @Before
    public void setUp(){
        machine=new BeverageMachine();
    }

    @Test
    public void addProduct(){
        Assert.assertEquals(true, machine.add(Product.GREEN_TEA));
    }


    @Test
    public void giveTea(){
        machine.add(Product.GREEN_TEA);
        Assert.assertEquals(true, machine.giveProduct());
    }

    @Test
    public void addCoin(){
        int value=5;
        initAddedCoin(value);
        Assert.assertEquals(true, machine.addCoin(value));
    }

    @Test
    public void addCoinValue(){
        initAddedCoin(5);
        Assert.assertEquals(5, machine.getCurrentInputValue());
    }

    private void initAddedCoin(int value) {
        machine.addCoin(value);
    }

    @Test
    public void add5CoinsValue(){
        initCoins(5,5);
        Assert.assertEquals(25, machine.getCurrentInputValue());
    }

    @Test
    public void buyProduct(){
        machine.add(Product.GREEN_TEA);
        initCoins(5,5);
        Assert.assertEquals(true, machine.buyProduct());
    }

    @Test
    public void MachineDoesntContainSuchProduct(){
        machine.add(Product.ESPRESSO);
        initCoins(5,5);
        Assert.assertEquals(false, machine.buyProduct());
    }

    @Test
    public void isntEnoughCoinsToBuyProduct(){
        machine.add(Product.GREEN_TEA);
        initCoins(5,4);
        Assert.assertEquals(false, machine.buyProduct());
    }

    @Test
    public void suchProductIsEmptyToBuy(){
        machine.add(Product.COFFEE);
        initCoins(5,5);
        Assert.assertEquals(false, machine.buyProduct());
    }


    private void initCoins(int value,int amount) {
        for(int i=0;i<amount;i++){
            machine.addCoin(value);
        }
    }
    @Ignore
    @Test
    public void giveChange(){
        machine.add(Product.GREEN_TEA);
        initCoins(10,3);
        machine.buyProduct();
        Assert.assertEquals(1, machine.getChange().keySet().size());
    }
}
