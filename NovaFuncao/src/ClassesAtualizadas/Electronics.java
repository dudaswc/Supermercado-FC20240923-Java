package ClassesAtualizadas;

public class Electronics extends Product {
    private int warrantyDaysLeft;

    public Electronics(String productName, String productCode, float productValuePerUnit, int stockQuantity, int warrantyDaysLeft) {
        super(productName, productCode, productValuePerUnit, stockQuantity);
        this.warrantyDaysLeft = warrantyDaysLeft;
    }

    public Electronics() {

    }

    public int getWarrantyDaysLeft() {
        return warrantyDaysLeft;
    }

    public void setWarrantyDaysLeft(int warrantyDaysLeft) {
        this.warrantyDaysLeft = warrantyDaysLeft;
    }

    @Override
    public void showProductInfo() {
        System.out.println("Produto Eletrônico: " + getProductName());
        System.out.println("Código: " + getProductCode());
        System.out.println("Valor: " + getProductValuePerUnit());
        System.out.println("Quantidade em estoque: " + getStockQuantity());
        System.out.println("Dias restantes de garantia: " + getWarrantyDaysLeft());
    }
}
