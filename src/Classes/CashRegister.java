package Classes;

class CashRegister {
    private double initialAmount; 
    private double currentAmount;
    private double totalSales;
    private boolean open;

    public void openRegister(double initialAmount) {
        if (open) {
            System.out.println("The register is already open.");
            return;
        }
        this.initialAmount = initialAmount; 
        this.currentAmount = initialAmount;
        this.open = true;
        System.out.printf("Register opened with $%.2f.%n", initialAmount);
    }

    public void closeRegister() {
        if (!open) {
            System.out.println("The register is already closed.");
            return;
        }
        System.out.printf("Initial amount: $%.2f%n", this.initialAmount); 
        System.out.printf("Total sales: $%.2f%n", totalSales);
        System.out.printf("Final balance in the register: $%.2f%n", currentAmount);
        open = false;
    }

    public void recordSale(double saleAmount) {
        if (!open) {
            System.out.println("The register is closed, sales cannot be recorded.");
            return;
        }
        currentAmount += saleAmount;
        totalSales += saleAmount;
    }
}

