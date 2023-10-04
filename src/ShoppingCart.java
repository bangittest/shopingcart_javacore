import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> products = new ArrayList<>();
    private int nextProductId = 1;

    public void addProduct(String productName, double productPrice, int quantity) {
        Product product = new Product(nextProductId++, productName, productPrice, quantity);
        products.add(product);
    }

    public void increaseQuantity(int index) {
        if (index >= 0 && index < products.size()) {
            Product product = products.get(index);
            product.setQuantity(product.getQuantity() + 1);
        }
    }

    public void decreaseQuantity(int index) {
        if (index >= 0 && index < products.size()) {
            Product product = products.get(index);
            if (product.getQuantity() > 1) {
                product.setQuantity(product.getQuantity() - 1);
            }
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public void showCart() {
        System.out.println("Sản phẩm trong giỏ hàng:");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void clearCart() {
        products.clear();
    }

}


