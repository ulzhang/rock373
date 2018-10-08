import java.util.ArrayList;

public class kcz223_Tester {
    public static void main (String [] args) {
        System.out.println("---");
        
        kcz223_Product p1 = new kcz223_Product("Jeans", 100);
        kcz223_Event e1 = new kcz223_Event("Training", 5, 200);
        
        kcz223_Shopping_Cart cart = new kcz223_Shopping_Cart ();
        cart.addItemToCart (p1);
        cart.addItemToCart (e1);
        print (cart);

        System.out.println("---");

        ArrayList items = new ArrayList();
        items.add ( new kcz223_Product("Dance", 50) );
        items.add ( new kcz223_Event("Class", 5, 100) );
        items.add (p1);
        items.add (e1);
        kcz223_Shopping_Cart cart2 = new kcz223_Shopping_Cart (items);
        print (cart2);

        System.out.println("---");
    }

    private static void print (kcz223_Shopping_Cart cart) {
        System.out.println("Number of cart items is " + cart.getCartItemCount());
        System.out.println("Total rpice of car items is $" + cart.getCartTotalPrice());
    }
}