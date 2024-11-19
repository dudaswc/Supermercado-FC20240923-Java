package Classes;

abstract class Product {
    private String code;
    private String name;
    private double unitPrice;
    private int stockQuantity;

    public Product(String code, String name, double unitPrice, int stockQuantity) {
        this.code = code;
        this.name = name;
        this.unitPrice = unitPrice;
        this.stockQuantity = stockQuantity;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void updateStock(int quantity) {
        if (quantity < 0 && Math.abs(quantity) > stockQuantity) {
            System.out.println("Insufficient stock.");
            return; 
        }
        stockQuantity += quantity;
    }

    public void updatePrice(double newPrice) {
        if (newPrice <= 0) {
            System.out.println("Price must be greater than zero.");
            return; 
        }
        unitPrice = newPrice;
    }

    public String displayDetails() {
        return String.format("Code: %s, Name: %s, Price: %.2f, Stock: %d", 
                getCode(), getName(), getUnitPrice(), getStockQuantity());
    }

}