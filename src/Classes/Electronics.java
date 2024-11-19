package Classes;

class Electronics extends Product {
    private int warrantyMonths;

    public Electronics(String code, String name, double unitPrice, int stockQuantity, int warrantyMonths) {
        super(code, name, unitPrice, stockQuantity);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public String displayDetails() {
        return super.displayDetails() + String.format(", Warranty: %d months", warrantyMonths);
    }
}