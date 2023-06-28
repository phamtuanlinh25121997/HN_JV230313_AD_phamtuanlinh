package ra;

import ra.model.CartItem;
import ra.model.Product;
import ra.service.CartService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BasicMenuApp {
    private static CartService cartService;

    public static void main(String[] args) {
        cartService = new CartService();
        int choice;
        Scanner scanner = new Scanner(System.in);
        do {
            displayBasicMenu();
            System.out.println("Nhập sự lựa chọn của bạn:");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    categoryManagement();
                    break;
                case 2:
                    productManagement();
                    break;
                case 3:
                    userMenu(scanner);
                    break;
                case 4:
                    System.out.println("Thoát khỏi chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
                    break;
            }
        } while (choice != 4);
    }

    private static void displayBasicMenu() {
        System.out.println("**************************BASIC-MENU**************************");
        System.out.println("1. Quản lý danh mục");
        System.out.println("2. Quản lý sản phẩm");
        System.out.println("3. Dành cho người dùng");
        System.out.println("4. Thoát");
    }

    private static void categoryManagement() {
        System.out.println("Tính năng đang bảo trì :).");
        System.out.println();
    }

    private static void productManagement() {
        System.out.println("Tính năng đang bảo trì :).");
        System.out.println();
    }

    private static void userMenu(Scanner scanner) {
        int choice;
        do {
            displayUserMenu();
            System.out.println("Nhập sự lựa chọn của bạn:");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    displayAllProducts();
                    break;
                case 2:
                    addToCart(scanner);
                    break;
                case 3:
                    displayCartItems();
                    break;
                case 4:
                    updateCartItemQuantity(scanner);
                    break;
                case 5:
                    removeCartItem(scanner);
                    break;
                case 6:
                    clearCart();
                    break;
                case 7:
                    System.out.println("Quay lại menu trước...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (choice != 7);
    }

    private static void displayUserMenu() {
        System.out.println("**************************MENU-USER**************************");
        System.out.println("1. Xem danh sách sản phẩm");
        System.out.println("2. Thêm vào giỏ hàng");
        System.out.println("3. Xem tất cả sản phẩm giỏ hàng");
        System.out.println("4. Thay đổi số lượng sản phẩm trong giỏ hàng");
        System.out.println("5. Xóa 1 sản phẩm trong giỏ hàng");
        System.out.println("6. Xóa toàn bộ sản phẩm trong giỏ hàng");
        System.out.println("7. Quay lại");
    }

    private static void displayAllProducts() {
        List<Product> products = new ArrayList<>();
        System.out.println("Sản phẩm có sẵn:");
        for (Product product : products){
            System.out.println(product);
        }
        System.out.println();
    }
    private static void addToCart(Scanner scanner){
        System.out.println("Nhập mã sản phẩm:");
        String productCode = scanner.next();
        System.out.println("Nhập số lượng:");
        int quantyti = scanner.nextInt();
    }
    private static void displayCartItems(){
        List<CartItem> cartItems = cartService.getCartItems();
        System.out.println("Các mặt hàng trong giỏ hàng:");
        for (CartItem cartItem : cartItems){
            System.out.println(cartItem);
        }
        System.out.println();
    }
    private static void updateCartItemQuantity(Scanner scanner){
        System.out.println("Nhập ID mặt hàng giỏ hàng:");
        String cartItemId = scanner.next();
        System.out.println("Nhập số lượng mới:");
        int quantyti = scanner.nextInt();
    }
    private static void removeCartItem(Scanner scanner){
        System.out.println("Nhập ID mặt hàng giỏ hàng:");
        String cartItemId = scanner.next();
    }
    private static void clearCart(){
        cartService.clearCart();
        System.out.println("Đã xóa sản phẩm trong giỏ hàng");
        System.out.println();
    }
}
