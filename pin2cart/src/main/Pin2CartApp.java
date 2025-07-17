package main;

import java.util.*;
import model.*;
import service.*;

public class Pin2CartApp {
	
	static Scanner scanner = new Scanner(System.in);
    static SearchService searchService = new SearchService();
    static CustomerService customerService = new CustomerService();
    static AdminService adminService = new AdminService();
    static List<ClickLog> clickLogs = new ArrayList<>();
    static List<Product> globalProductList = new ArrayList<>();

    public static void main(String[] args) {

        //Greeting Banner
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║           Welcome to 🛒 Pin2Cart           ║");
        System.out.println("║  Find What You Love, Buy What You See 💖   ║");
        System.out.println("╚════════════════════════════════════════════╝");

        while (true) {
            System.out.println("\nSelect your role:");
            System.out.println("1. Customer");
            System.out.println("2. Admin");
            System.out.println("3. Exit");

            int input = scanner.nextInt();

            switch (input) {
                case 1 -> handleCustomer();
                case 2 -> handleAdmin();
                case 3 -> {
                    System.out.println("Thanks for shopping with Pin2Cart! 👋");
                    return;
                }
                default -> System.out.println("❌ Please select a valid option (1-3).");
            }
        }
    }

    public static void handleCustomer() {
        Customer customer = new Customer();
        Cart cart = new Cart();

        System.out.print("Enter your User ID: ");
        customer.setUserId(scanner.nextInt());
        scanner.nextLine(); // Consume newline

        System.out.print("Enter your name: ");
        customer.setUsername(scanner.nextLine());

        System.out.print("Enter your email: ");
        customer.setEmail(scanner.nextLine());

        customerService.createCustomer(customer);
        System.out.println("🎉 Welcome aboard, " + customer.getUsername() + "!");

        boolean active = true;
        while (active) {
            System.out.println("\nCustomer Options:");
            System.out.println("1. Search Products by Keyword");
            System.out.println("2. View Search Results");
            System.out.println("3. Add to Wishlist");
            System.out.println("4. View Wishlist");
            System.out.println("5. Add to Cart");
            System.out.println("6. View Cart");
            System.out.println("7. Checkout");
            System.out.println("8. Redirect to Purchase");
            System.out.println("9. Search Using Pinterest URL");
            System.out.println("10. Exit");

            if (!scanner.hasNextInt()) {
                System.out.println("❌ Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter search keyword: ");
                    String keyword = scanner.nextLine();
                    List<Product> results = searchService.searchByKeyword(keyword);
                    customer.setSearchResults(results);
                    globalProductList.addAll(results);

                    System.out.println("🔍 Products found:");
                    for (Product product : results) {
                        System.out.println(product);
                    }
                }

                case 2 -> {
                    System.out.println("🗂 Your Search Results:");
                    for (Product product : customer.getSearchResults()) {
                        System.out.println(product);
                    }
                }

                case 3 -> {
                    System.out.print("Enter Product ID to add to Wishlist: ");
                    if (scanner.hasNextInt()) {
                        int pid = scanner.nextInt();
                        for (Product product : customer.getSearchResults()) {
                            if (product.getProductId() == pid) {
                                customerService.addToWishlist(customer, product);
                                break;
                            }
                        }
                    } else {
                        System.out.println("❌ Invalid Product ID. Please enter a number.");
                        scanner.nextLine();
                    }
                }

                case 4 -> customerService.showWishlist(customer);

                case 5 -> {
                    System.out.print("Enter Product ID to add to Cart: ");
                    if (scanner.hasNextInt()) {
                        int pid = scanner.nextInt();
                        for (Product product : customer.getSearchResults()) {
                            if (product.getProductId() == pid) {
                                cart.add(product);
                                System.out.println("✅ Added to Cart: " + product.getName());
                                break;
                            }
                        }
                    } else {
                        System.out.println("❌ Please enter a valid numeric Product ID.");
                        scanner.nextLine();
                    }
                }

                case 6 -> cart.view();

                case 7 -> {
                    if (cart.getItems().isEmpty()) {
                        System.out.println("🛒 Your cart is empty. Add something before checking out!");
                        break;
                    }

                    System.out.print("Full Name: ");
                    String fullName = scanner.nextLine();

                    System.out.print("Shipping Address: ");
                    String address = scanner.nextLine();

                    System.out.print("Contact Number: ");
                    String phone = scanner.nextLine();

                    Order order = new Order(cart.getItems(), cart.total(), fullName, address, phone);
                    order.printReceipt();
                    cart.clear();
                    System.out.println("✅ Thank you! Your order has been placed.");
                }

                case 8 -> {
                    System.out.print("Enter Product ID to Buy Now: ");
                    if (scanner.hasNextInt()) {
                        int pid = scanner.nextInt();
                        for (Product product : customer.getSearchResults()) {
                            if (product.getProductId() == pid) {
                                customer.redirectToPurchase(product);
                                clickLogs.add(new ClickLog(
                                        customer.getUserId(),
                                        product.getProductId(),
                                        new Date(),
                                        product.getRedirectLink()));
                                break;
                            }
                        }
                    } else {
                        System.out.println("❌ Invalid Product ID.");
                        scanner.nextLine();
                    }
                }

                case 9 -> {
                    System.out.print("📎 Paste Pinterest image link: ");
                    String link = scanner.nextLine();
                    String keywordFromLink = extractFromPinterest(link);
                    List<Product> results = searchService.searchByKeyword(keywordFromLink);
                    customer.setSearchResults(results);
                    globalProductList.addAll(results);

                    System.out.println("🔎 Results from Pinterest Image:");
                    for (Product product : results) {
                        System.out.println(product);
                    }
                }

                case 10 -> active = false;

                default -> System.out.println("❌ Invalid menu option.");
            }
        }
    }

    // Extract pin ID or hash from Pinterest URL
    public static String extractFromPinterest(String url) {
        if (url.contains("pinimg.com/")) {
            return url.substring(url.lastIndexOf("/") + 1).replace(".jpg", "");
        } else if (url.contains("pinterest.com/pin/")) {
            return url.substring(url.lastIndexOf("/") + 1);
        }
        return url;
    }

    public static void handleAdmin() {
        boolean adminActive = true;

        while (adminActive) {
            System.out.println("\nAdmin Panel:");
            System.out.println("1. Show Flagged Products");
            System.out.println("2. Show Click Logs");
            System.out.println("3. Back to Main Menu");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> adminService.viewFlaggedProducts(globalProductList);
                case 2 -> adminService.viewClickLogs(clickLogs);
                case 3 -> adminActive = false;
                default -> System.out.println("❌ Please choose a valid admin option.");
            }
        }
    }

}
