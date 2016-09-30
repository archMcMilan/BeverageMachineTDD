/**
 * Created by Artem_Pryzhkov on 9/30/2016.
 */
public class Product {
    private String description;
    private int price;

    public Product(String desc, int price) {
        this.description=desc;
        this.price=price;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }
}
