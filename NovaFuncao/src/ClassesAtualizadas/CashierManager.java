package ClassesAtualizadas;
import java.util.ArrayList;

	public class CashierManager {
	    Terminal terminal = new Terminal();
	    ArrayList<Product> productList = new ArrayList<>();
	    double initialCashBalance = 0;
	    double cashBalance = 0;

	    void startNewCashier() {
	        initialCashBalance = terminal.showAmountProfitedBefore();
	        cashBalance = initialCashBalance;
	        loop();
	    }

	    void loop() {
	        int opcao;
	        for (;;) {
	            opcao = terminal.showMainMenu();
	            if (opcao == 1) {
	                handleProductPurchase();
	            } else if (opcao == 2) {
	                handleRegisterProduct();
	            } else if (opcao == 3) {
	                handleRemoveProduct();
	            } else if (opcao == 4) {
	                handleGenerateReport();
	            } else if (opcao == 5) {
	                handleSearchProductByName();
	            } else if (opcao == 6) {
	                finishSalesToday();
	                break;
	            }
	        }
	    }

	    private void handleProductPurchase() {
	        ArrayList<Product> productsAddedToCart = new ArrayList<>();
	        ArrayList<Integer> productAmountInCart = new ArrayList<>();
	        double total = 0;

	        for (;;) {
	            Product currentProduct = handleSearchProductByCode(Console.readText("Código do produto: "));
	            if (currentProduct == null) {
	                System.out.println("Produto não encontrado.");
	                continue;
	            }

	            int quantity = Console.readNumber("Quantidade de produtos: ");
	            if (quantity > currentProduct.getStockQuantity()) {
	                System.out.println("Quantidade em estoque insuficiente.");
	                continue;
	            }

	            productsAddedToCart.add(currentProduct);
	            productAmountInCart.add(quantity);
	            total += currentProduct.getProductValuePerUnit() * quantity;

	            currentProduct.reduceStock(quantity);

	            if (Console.readText("Fechar caixa? (s/n): ").equals("s")) {
	                terminal.showFinishedPurchaseMenu(total);
	                cashBalance += total;
	                displayGroupedProducts(productsAddedToCart, productAmountInCart);
	                break;
	            }
	        }
	    }

	    private void displayGroupedProducts(ArrayList<Product> products, ArrayList<Integer> amounts) {
	        ArrayList<String> groupedProducts = new ArrayList<>();
	        ArrayList<Integer> groupedQuantities = new ArrayList<>();
	        double total = 0;

	        for (int i = 0; i < products.size(); i++) {
	            Product currentProduct = products.get(i);
	            int currentAmount = amounts.get(i);
	            String currentProductName = currentProduct.getProductName();

	            boolean found = false;
	            for (int j = 0; j < groupedProducts.size(); j++) {
	                if (groupedProducts.get(j).equals(currentProductName)) {
	                    groupedQuantities.set(j, groupedQuantities.get(j) + currentAmount);
	                    found = true;
	                    break;
	                }
	            }

	            if (!found) {
	                groupedProducts.add(currentProductName);
	                groupedQuantities.add(currentAmount);
	            }
	        }

	        for (int i = 0; i < groupedProducts.size(); i++) {
	            String productName = groupedProducts.get(i);
	            int quantity = groupedQuantities.get(i);
	            double productPrice = getProductPriceByName(products, productName);
	            double productTotal = productPrice * quantity;

	            System.out.println(quantity + "x " + productName + " - " + productTotal);
	            total += productTotal;
	        }

	        System.out.println("Total: " + total);
	    }

	    private double getProductPriceByName(ArrayList<Product> products, String productName) {
	        for (Product product : products) {
	            if (product.getProductName().equals(productName)) {
	                return product.getProductValuePerUnit();
	            }
	        }
	        return 0;
	    }

	    private Product handleRegisterProduct() {
	        int escolha = terminal.registerProduct();
	        switch (escolha) {
	            case 1:
	                productList.add(terminal.registerProductTypeAliment());
	                break;
	            case 2:
	                productList.add(terminal.registerProductTypeElectronic());
	                break;
	            default:
	                terminal.showInvalidAction();
	        }
	        return null;
	    }

	    private Product handleSearchProductByCode(String code) {
	        for (Product interatingProduct : productList) {
	            if (code.equals(interatingProduct.getProductCode())) {
	                return interatingProduct;
	            }
	        }
	        return null;
	    }

	    private void handleRemoveProduct() {
	        String productCode = terminal.showRemoveProductMenu();
	        if (terminal.confirmActionMenu()) {
	            for (Product product : productList) {
	                if (product.getProductCode().equals(productCode)) {
	                    productList.remove(product);
	                    terminal.ShowProductRemovedSuccessfully();
	                    break;
	                }
	            }
	        }
	    }

	    private void handleSearchProductByName() {
	        String productName = terminal.showSearchMenu();
	        for (Product interatingProduct : productList) {
	            if (productName.equals(interatingProduct.getProductName())) {
	                terminal.showProductInfo(interatingProduct);
	                return;
	            }
	        }
	        terminal.showProductMissing();
	    }

	    public void handleGenerateReport() {
	        int choice = terminal.generateReport();

	        if (choice == 1) {
	            System.out.println("Relatório de Produtos por validade:");
	            generateValidityReport();
	        } else if (choice == 2) {
	            System.out.println("\nRelatório de produtos por quantidade em estoque:");
	            generateStockQuantityReport();
	        } else if (choice == 3) {
	            System.out.println("\nRelatório de vendas por popularidade:");
	            generateSalesReportByPopularity();
	        } else if (choice == 4) {
	            return;
	        }
	    }

	    private void generateValidityReport() {
	        int amountOfDays = terminal.showAmountOfDaysToSearch();

	        for (Product product : productList) {
	            if (product instanceof Electronics) {
	                Electronics electronics = (Electronics) product;
	                if (electronics.getWarrantyDaysLeft() <= amountOfDays) {
	                    System.out.println("Produto: " + electronics.getProductName() + " | Validade: " + electronics.getWarrantyDaysLeft() + " dias");
	                }
	            } else if (product instanceof Aliments) {
	                Aliments aliments = (Aliments) product;
	                if (aliments.getValidityDaysLeft() <= amountOfDays) {
	                    System.out.println("Produto: " + aliments.getProductName() + " | Validade: " + aliments.getValidityDaysLeft() + " dias");
	                }
	            }
	        }
	    }

	    private void generateStockQuantityReport() {
	        int stockLimit = terminal.showAmountOfStockToSearch();

	        for (Product product : productList) {
	            if (product.getStockQuantity() <= stockLimit) {
	                System.out.println("Produto: " + product.getProductName() + " | Quantidade em Estoque: " + product.getStockQuantity() + " unidades");
	            }
	        }
	    }

	    private void generateSalesReportByPopularity() {
	        ArrayList<ProductInCart> salesReport = new ArrayList<>();

	        for (Product product : productList) {
	            salesReport.add(new ProductInCart(product, product.getStockQuantity()));
	        }

	        salesReport.sort((p1, p2) -> Integer.compare(p2.getQuantity(), p1.getQuantity()));

	        System.out.println("\nRelatório de vendas (mais vendidas para menos vendidas):");
	        for (ProductInCart productInCart : salesReport) {
	            System.out.println("Produto: " + productInCart.getProduct().getProductName()
	                    + " | Quantidade Vendida: " + productInCart.getQuantity());
	        }
	    }

	    private void finishSalesToday() {
	        terminal.showFinishSalesToday(initialCashBalance, cashBalance);
	    }
	}


