import java.util.ArrayList;

public class kcz223_Shopping_Cart {
    private ArrayList items;
    public kcz223_Shopping_Cart() {
        this.items = new ArrayList();
    }

    public kcz223_Shopping_Cart(ArrayList itemsPassedIn) {
        this(); // calls the constructor above to initialize the items ArrayList
        for (Object cartItemObject : itemsPassedIn) {
            kcz223_Sellable item = (kcz223_Sellable) cartItemObject;
            addItemToCart( item ); //assumes you have already written the addItemToCart method
        }
    }

    public void addItemToCart(kcz223_Sellable item) {
        System.out.println("Added " + item.getName() + " costing $" + item.getPrice() +  " to cart.");
    }

    public int getCartItemCount() {
        return this.items.size();
    }

    public int getCartTotalPrice() {
        int total = 0;
        for (int i = 1; i < this.items.size(); i++) {
            int curr = this.items.get(i);
            total += curr.getPrice();
        }
        return total;
    }

    public void printToScreen() {

    }

}