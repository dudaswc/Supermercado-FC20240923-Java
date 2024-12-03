package ClassesAtualizadas;

public class Aliments extends Product {
	    private int validityDaysLeft;

	    public Aliments(String productName, String productCode, float productValuePerUnit, int stockQuantity, int validityDaysLeft) {
	        super(productName, productCode, productValuePerUnit, stockQuantity);
	        this.validityDaysLeft = validityDaysLeft;
	    }

	    public Aliments() {
	        super();
	    }

	    public int getValidityDaysLeft() {
	        return validityDaysLeft;
	    }

	    public void setValidityDaysLeft(int validityDaysLeft) {
	        this.validityDaysLeft = validityDaysLeft;
	    }

	    @Override
	    public void showProductInfo() {
	        System.out.println("Produto Alimentício: " + getProductName());
	        System.out.println("Código: " + getProductCode());
	        System.out.println("Valor: " + getProductValuePerUnit());
	        System.out.println("Quantidade em estoque: " + getStockQuantity());
	        System.out.println("Dias de validade restantes: " + getValidityDaysLeft());
	    }
	}


