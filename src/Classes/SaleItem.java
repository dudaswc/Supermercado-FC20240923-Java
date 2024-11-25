package Classes;

class SaleItem {
    private Product product;
    private int quantity;

    public SaleItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        return product.getUnitPrice() * quantity;
    }

    public void incrementQuantity(int quantity) {
        this.quantity += quantity;
    }
}
