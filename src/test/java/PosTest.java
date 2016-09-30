import org.junit.*;

public class PosTest {
    BeverageMachine machine;

    @Before
    public void setUp(){
        machine=new BeverageMachine();
        Product greenTea=new Product("green tea",25);
        Product blackTea=new Product("black coffee",25);
        Product coffee=new Product("coffee",35);
    }

    @Test
    public void addProduct(){
        Product greenTea=new Product("green tea",25);
        Assert.assertEquals(true, machine.add(greenTea));
    }

    @Test
    public void addProducts(){
        Product greenTea=new Product("green tea",25);
        Assert.assertEquals(true, machine.add(greenTea,5));
    }

    @Test
    public void giveTea(){
        Product greenTea=new Product("green tea",25);
        machine.add(greenTea);
        Assert.assertEquals(true, machine.giveProduct(greenTea));
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
        initCoins(5,5);
        Product greenTea=new Product("green tea",25);
        Assert.assertEquals(25, machine.buyProduct());
    }


    private void initCoins(int value,int amount) {
        for(int i=0;i<amount;i++){
            machine.addCoin(value);
        }
    }
}
