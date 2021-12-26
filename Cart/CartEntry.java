package Cart;
import home.Product;
public class CartEntry {
    private Product product;
    private static int quantity;
    public CartEntry(Product product, int quantity){
        this.product=product;
        this.quantity=quantity;
    }

    public Product getProduct() {
        return product;
    }

    public static int getQuantity() {
        return quantity;
    }
    public void increaseQuantity(){
        this.quantity++;
    }
    public void decreaseQuantity(){
        if(this.quantity>0){
            this.quantity--;
        }
    }
}