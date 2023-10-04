import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        while (true) {
            System.out.println("1. Thêm sản phẩm vào giỏ hàng");
            System.out.println("2. Xem giỏ hàng và tăng/giảm ID sản phẩm");
            System.out.println("3. Tổng tiền");
            System.out.println("4. Checkout");
            System.out.println("5. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc ký tự newline

            switch (choice) {
                case 1:
                    scanner.nextLine(); // Tiêu thụ dấu xuống dòng còn lại
                    System.out.print("Nhập tên sản phẩm: ");
                    String productName = scanner.nextLine();
                    System.out.print("Nhập giá sản phẩm (VND): ");
                    double productPrice = scanner.nextDouble();
                    System.out.print("Nhập số lượng sản phẩm: ");
                    int productQuantity = scanner.nextInt();
                    cart.addProduct(productName, productPrice, productQuantity); // Truyền số lượng sản phẩm
                    System.out.println("Sản phẩm đã được thêm vào giỏ hàng.");
                    break;


                case 2:
                    cart.showCart(); // Gọi hàm showCart để hiển thị giỏ hàng
                    System.out.print("Nhập số thứ tự sản phẩm để tăng hoặc giảm số lượng (hoặc 0 để quay lại): ");
                    int choiceProduct = scanner.nextInt();
                    if (choiceProduct >= 1 && choiceProduct <= cart.getProducts().size()) {
                        System.out.print("1. Tăng số lượng\n2. Giảm số lượng\nNhập lựa chọn của bạn: ");
                        int quantityChoice = scanner.nextInt();
                        if (quantityChoice == 1) {
                            cart.increaseQuantity(choiceProduct - 1);
                            System.out.println("Số lượng sản phẩm đã được tăng lên.");
                        } else if (quantityChoice == 2) {
                            cart.decreaseQuantity(choiceProduct - 1);
                            System.out.println("Số lượng sản phẩm đã được giảm xuống.");
                        } else {
                            System.out.println("Lựa chọn không hợp lệ.");
                        }
                    } else if (choiceProduct == 0) {
                        // Quay lại menu chính
                    } else {
                        System.out.println("Lựa chọn không hợp lệ.");
                    }
                    break;
                case 3:
                    double total = 0;
                    for (Product product : cart.getProducts()) {
                        total += product.getPrice();
                    }
                    System.out.println("Tổng tiền trong giỏ hàng: " + total + " VND");
                    break;
                case 4:
                    scanner.nextLine(); // Tiêu thụ dấu xuống dòng còn lại
                    System.out.print("Nhập họ và tên: ");
                    String fullName = scanner.nextLine();
                    System.out.print("Nhập địa chỉ: ");
                    String address = scanner.nextLine();
                    System.out.print("Nhập số điện thoại: ");
                    String phoneNumber = scanner.nextLine();

                    // Kiểm tra xem người dùng đã nhập thông tin họ tên, địa chỉ và số điện thoại hay chưa
                    if (fullName.isEmpty() || address.isEmpty() || phoneNumber.isEmpty()) {
                        System.out.println("Vui lòng nhập đầy đủ thông tin họ tên, địa chỉ và số điện thoại để thanh toán.");
                    } else {
                        // Yêu cầu xác nhận thanh toán
                        System.out.print("Nhập 'ok' để xác nhận thanh toán: ");
                        String confirmation = scanner.nextLine();

                        if ("ok".equalsIgnoreCase(confirmation)) {
                            // Thực hiện thanh toán và in hóa đơn ở đây
                            System.out.println("Đã thanh toán thành công!");
                            System.out.println("Hóa đơn:");
                            cart.showCart();
                            System.out.println("Họ và tên: " + fullName);
                            System.out.println("Địa chỉ: " + address);
                            System.out.println("Số điện thoại: " + phoneNumber);
                            cart.clearCart();
                        } else {
                            System.out.println("Thanh toán không được xác nhận.");
                        }
                    }
                    break;


                case 5:
                    System.out.println("Kết thúc chương trình.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
    }
}
