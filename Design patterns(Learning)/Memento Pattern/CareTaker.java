package MementoPattern;

import java.util.Stack;

public class CareTaker {

    Stack<Cart.CartMemento> history = new Stack<>();

    public void save(Cart cart){
        history.push(cart.save());
    }

    public void revert(Cart cart){
        if (!history.isEmpty()){
            cart.revertCart(history.pop());

        }else {
            System.out.println("Cannot undo");
        }
    }
}