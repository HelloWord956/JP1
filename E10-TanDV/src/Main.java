import Controller.ProductController;
import Entity.Product;
import ExceptionValidation.InvalidProducCodeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<Product>();
        ProductController productController = new ProductController();
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        while (!quit) {
            try{
                Product product = new Product();
                System.out.println("Enter product code: ");
                String pCode = scanner.nextLine();
                product.setCode(pCode);
                System.out.println("Enter product name: ");
                String pName = scanner.nextLine();
                product.setName(pName);
                productController.add(product);
                quit = true;
            } catch (InvalidProducCodeException ipce) {
                System.out.println(ipce.getMessage());
            }
        }
    }
}