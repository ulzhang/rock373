public class kcz223_Product implements kcz223_Sellable {
    private String name;
    private int price;

    public kcz223_Product(String addName, int addPrice) {
        this.name = addName;
        this.price = addPrice;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }
}