/**
 * Created by Artem_Pryzhkov on 9/30/2016.
 */
public enum  Product {
    GREEN_TEA("green tea",25),BLACK_TEA("black tea",25),COFFEE("coffee",35),ESPRESSO("espresso",50);

    private String description;
    private int price;

    Product(String desc, int price) {
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
