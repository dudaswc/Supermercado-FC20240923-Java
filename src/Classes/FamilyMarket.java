package Classes;

import java.util.ArrayList;
import java.util.List;

public class FamilyMarket {
    public static void main(String[] args) {
        CashRegister register = new CashRegister();
        List<Product> products = new ArrayList<>();
        products.add(new FoodAndUtensils("001", "Apple", 3.5, 100, 7));
        products.add(new FoodAndUtensils("002", "Bread", 1.0, 50, 3));
        products.add(new Electronics("101", "Microwave", 400.0, 5, 12));

        register.openRegister(100.0);

        Sale sale = new Sale();
        sale.addProduct(products.get(0), 10); // 10 apples
        sale.addProduct(products.get(1), 5);  // 5 breads

        double total = sale.finalizeSale();
        register.recordSale(total);

        System.out.printf("Subtotal: $%.2f%n", total);

        register.closeRegister();
    }
}