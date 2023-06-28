package ra.service;

import ra.model.CartItem;
import ra.model.Product;

import java.util.ArrayList;
import java.util.List;

public class CartService {
    private List<CartItem> cartItems;

    public CartService() {
        cartItems = new ArrayList<>();
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void addToCart(Product product, int quatity) {
        for (CartItem item : cartItems) {
            if (item.getProduct().equals(product)) {
                int newQuatity = item.getQuantity() + quatity;
                if (newQuatity > product.getStock()) {
                    System.out.println("Not enough stock available.");
                    return;
                }
                item.setQuantity(newQuatity);
                return;
            }
        }
        if (quatity <= product.getStock()) {
            CartItem newItem = new CartItem();
            newItem.setCartItemId(generateCartItemId());
            newItem.setProduct(product);
            newItem.setPrice(product.getPrice());
            newItem.setQuantity(quatity);
            cartItems.add(newItem);
        } else {
            System.out.println("Not enough stock available.");
        }
    }

    public void updateCartItemQuantity(String cartItemId, int quatity) {
        CartItem cartItem = findCartItemById(cartItemId);
        if (cartItem != null) {
            Product product = cartItem.getProduct();
            int stockDifference = quatity - cartItem.getQuantity();
            if (quatity <= product.getStock() + stockDifference) {
                cartItem.setQuantity(quatity);
                product.setStock(product.getStock() + stockDifference);
            } else {
                System.out.println("Not enough stock available.");
            }
        } else{
            System.out.println("Không tìm thấy mặt hàng trong giỏ hàng.");
        }
    }
    public void removeCartItem(String cartItemId){
        CartItem cartItem = findCartItemById(cartItemId);
        if (cartItem != null){
            cartItems.remove(cartItem);
            Product product=cartItem.getProduct();
            product.setStock(product.getStock() + cartItem.getQuantity());
        }else {
            System.out.println("Không tìm thấy mặt hàng trong giỏ hàng.");
        }
    }
    public void clearCart(){
        for (CartItem cartItem: cartItems){
            Product product = cartItem.getProduct();
            product.setStock(product.getStock()+ cartItem.getQuantity());
        }
        cartItems.clear();
    }
    private CartItem findCartItemById(String cartItemId){
        for (CartItem cartItem : cartItems){
            if (cartItem.getCartItemId().equals(cartItemId)){
                return cartItem;
            }
        }
        return null;
    }
    private String generateCartItemId(){
        return null;
    }
}
