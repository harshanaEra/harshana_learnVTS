package MementoPattern;

public class Application {
    public static void main(String[] args) {
        CareTaker careTaker = new CareTaker();
        Cart cart = new Cart();
        cart.addItem(new Item("book"));
        cart.addItem(new Item("pc"));

        careTaker.save(cart);
        System.out.println(cart);

        cart.addItem(new Item("dgfdsg"));
        careTaker.save(cart);
        System.out.println(cart);
        cart.addItem(new Item("pfdgdfc"));
        careTaker.save(cart);
        System.out.println(cart);
        careTaker.revert(cart);
        System.out.println(cart);
        careTaker.revert(cart);
        System.out.println(cart);
    }

}