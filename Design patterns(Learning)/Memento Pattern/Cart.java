package MementoPattern;

//originator

import java.util.ArrayList;

public class Cart {

    ArrayList<Item> items = new ArrayList<>();

    public void addItem(Item item){
        items.add(item);
    }

    public Cart(ArrayList<Item> items) {
        this.items = items;
    }

    public Cart() {

    }

    public ArrayList<Item> getItems() {
        return (ArrayList<Item>) items.clone();
    }

    public CartMemento save(){
        return new CartMemento(getItems());
    }

    public void revertCart(CartMemento cartMemento){
        items = cartMemento.getItems();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "items=" + items +
                '}';
    }

    static class CartMemento{
        ArrayList<Item> items;

        public CartMemento(ArrayList<Item> items) {
            this.items = items;
        }

        public ArrayList<Item> getItems() {
            return items;
        }
    }
}