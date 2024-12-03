package ClassesAtualizadas;

public abstract class Product {
    private String productName;
    private String productCode;
    private float productValuePerUnit;
    private int stockQuantity; // Quantidade em estoque

    public Product(String productName, String productCode, float productValuePerUnit, int stockQuantity) {
        this.productName = productName;
        this.productCode = productCode;
        this.productValuePerUnit = productValuePerUnit;
        this.stockQuantity = stockQuantity;
    }

    public Product() {

    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public float getProductValuePerUnit() {
        return productValuePerUnit;
    }

    public void setProductValuePerUnit(float productValuePerUnit) {
        this.productValuePerUnit = productValuePerUnit;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    // Método para reduzir a quantidade no estoque quando um produto é vendido
    public void reduceStock(int quantity) {
        if (quantity <= stockQuantity) {
            stockQuantity -= quantity;
        } else {
            System.out.println("Quantidade insuficiente em estoque.");
        }
    }

    // Método abstrato para ser implementado pelas subclasses
    public abstract void showProductInfo();
}

