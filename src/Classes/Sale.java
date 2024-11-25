package Classes;

import java.util.ArrayList;
import java.util.List;

public class Sale {
    private List<SaleItem> saleItems; 
    private double subtotal;

    public Sale() {
        saleItems = new ArrayList<>();
        subtotal = 0.0;
    }

    public void addProduct(Product product, int quantity) {
        if (quantity <= 0) {
            System.out.println("Quantity must be greater than zero.");
            return;
        }
        if (product.getStockQuantity() < quantity) {
            System.out.println("Insufficient stock.");
            return;
        }

        for (SaleItem item : saleItems) {
            if (item.getProduct().equals(product)) {
                item.incrementQuantity(quantity);
                subtotal += product.getUnitPrice() * quantity;
                return;
            }
        }

        saleItems.add(new SaleItem(product, quantity));
        subtotal += product.getUnitPrice() * quantity;
    }

    public double finalizeSale() {
        for (SaleItem item : saleItems) {
            item.getProduct().updateStock(-item.getQuantity()); 
        }
        double total = subtotal;
        saleItems.clear(); 
        subtotal = 0.0;
        return total;
    }
}
