package ClassesAtualizadas;
import java.util.Objects;

public class Terminal {

	    public double showAmountProfitedBefore(){
	        System.out.println("Insira o valor monetário inicial do caixa.");
	        return Console.readNumber("Escolha: ");
	    }

	    public int showMainMenu() {
	        System.out.println("MENU PRINCIPAL");
	        System.out.println("1 - Realizar Venda");
	        System.out.println("2 - Cadastrar produtos");
	        System.out.println("3 - Remover Produtos");
	        System.out.println("4 - Gerar Relatórios");
	        System.out.println("5 - Buscar produto");
	        System.out.println("6 - Fechar o caixa hoje");
	        return Console.readNumber("Escolha sua opção: ");
	    }

	    public int registerProduct() {
	        System.out.println("CADASTRO DE PRODUTOS");
	        System.out.println("1. Cadastrar Alimento");
	        System.out.println("2. Cadastrar Eletrônico");
	        return Console.readNumber("Escolha: ");
	    }

	    public Aliments registerProductTypeAliment() {
	        Aliments aliment = new Aliments();
	        aliment.setProductName(Console.readText("Nome do Alimento: "));
	        aliment.setProductCode(Console.readText("Código do Alimento: "));
	        aliment.setValidityDaysLeft(Console.readNumber("Dias de validade: "));
	        aliment.setProductValuePerUnit(Console.readNumber("Preço por unidade: "));
	        return aliment;
	    }

	    public Electronics registerProductTypeElectronic() {
	        Electronics electronic = new Electronics();
	        electronic.setProductName(Console.readText("Nome do Eletrônico: "));
	        electronic.setProductCode(Console.readText("Código do Eletrônico: "));
	        electronic.setWarrantyDaysLeft(Console.readNumber("Dias de Garantia: "));
	        electronic.setProductValuePerUnit(Console.readNumber("Preço por unidade: "));
	        return electronic;
	    }

	    public String showRemoveProductMenu() {
	        System.out.println("REMOVER PRODUTO");
	        return Console.readText("Código do produto: ");
	    }

	    public boolean confirmActionMenu() {
	        System.out.println("Tem certeza? (s/n): ");
	        return Objects.equals(Console.readText(""), "s");
	    }

	    public void showFinishedPurchaseMenu(double total) {
	        System.out.println("Resumo da compra:");
	        System.out.println("TOTAL: R$ " + String.format("%.2f", total));
	    }

	    public void showProductMissing() {
	        System.out.println("Produto não encontrado");
	    }

	    public void showFinishSalesToday(double initialBalance, double total) {
	        System.out.println("O caixa iniciou o dia com: R$ " + String.format("%.2f", initialBalance));
	        System.out.println("Total de vendas do dia foi: R$ " + String.format("%.2f", total));
	    }

	    public void showInvalidAction() {
	        System.out.println("Ação inválida.");
	    }

	    public void ShowProductRemovedSuccessfully() {
	        System.out.println("Produto removido com sucesso.");
	    }

	    public String showSearchMenu() {
	        return Console.readText("Digite o nome do produto para buscar: ");
	    }

	    public int generateReport() {
	        System.out.println("RELATÓRIOS");
	        System.out.println("1 - Produtos por validade");
	        System.out.println("2 - Produtos por quantidade em estoque");
	        System.out.println("3 - Vendas por popularidade");
	        System.out.println("4 - Voltar");
	        return Console.readNumber("Escolha sua opção: ");
	    }


	    public int showAmountOfDaysToSearch(){
	        return Console.readNumber("Pesquisar por quantidade de dias - Até quantos dias quer ver?");
	    }
	    public int showAmountOfStockToSearch(){
	        return Console.readNumber("Pesquisar por quantidade em estoque - Até quantos no estoque quer ver?");
	    }

	    public void showProductInfo(Product product) {
	        System.out.println("Produto: " + product.getProductName());
	        System.out.println("Código: " + product.getProductCode());
	        System.out.println("Preço unitário: R$ " + product.getProductValuePerUnit());
	        System.out.println("Quantidade em estoque: " + product.getStockQuantity());
	    }
	}


