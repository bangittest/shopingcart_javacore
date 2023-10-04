public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity; // Thêm trường quantity

    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity; // Khởi tạo quantity
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
// Getters và setters cho quantity

    @Override
    public String toString() {
        return "ID: " + id + " - " + name + " - " + price + " VND - Quantity: " + quantity;
    }
}
