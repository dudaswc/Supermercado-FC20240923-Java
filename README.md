# Supermercado-FC20240923-Java
Trabalho da Disciplina de Programação Orientada a Objetos, 2024/2

---

# Simulador Mercado

## **Descrição do Problema**
O projeto **Simulador Mercado** foi desenvolvido para atender a uma necessidade comum de pequenos mercados familiares que ainda realizam o gerenciamento de suas operações de forma manual, como em cadernos ou planilhas simples. Este sistema tem como objetivo modernizar e automatizar as principais atividades do dia a dia de um mercado, como controle de estoque, fluxo de caixa, vendas e relatórios.

O sistema ajuda a reduzir erros operacionais, melhora a organização e fornece uma visão mais detalhada e acessível das operações do mercado.

---

## **Objetivo do Sistema**
O sistema foi projetado para:

- Substituir o gerenciamento manual por um sistema informatizado e eficiente.
- Facilitar o controle financeiro diário, permitindo rastrear abertura, movimentações e fechamento do caixa.
- Automatizar o controle de estoque, incluindo cadastro e atualização de produtos.
- Registrar vendas e atualizar estoques de forma automática após cada transação.
- Gerar relatórios úteis para o gestor, como produtos próximos ao vencimento ou com baixa quantidade no estoque.

---

## **Principais Funcionalidades**

### **Gerenciamento de Caixa**
- Permite ao funcionário abrir o caixa no início do dia, informando o valor inicial em dinheiro.
- Durante o dia, registra todas as vendas e movimentações financeiras.
- Ao final do expediente, calcula o valor final em caixa, mostrando o total de vendas realizadas e o saldo final.

### **Cadastro e Controle de Produtos**
- Cadastro de dois tipos principais de produtos:
  - **Alimentos e Utensílios**: Inclui campos como código, nome, preço, validade e quantidade em estoque.
  - **Eletroeletrônicos**: Inclui campos como código, nome, preço, quantidade em estoque e garantia.
- Permite buscar produtos pelo nome ou código.
- Permite atualização de preços e remoção de produtos quando necessário.

### **Gestão de Vendas**
- Realiza o registro de vendas, permitindo adicionar e remover itens do carrinho.
- Calcula automaticamente o subtotal acumulado durante a venda.
- Atualiza o estoque dos produtos vendidos após a finalização da compra.
- Agrupa os itens na venda, exibindo quantidades de forma clara.

### **Relatórios Gerenciais**
- **Produtos a vencer**: Lista produtos cuja validade expira dentro de um período específico informado pelo gestor.
- **Produtos com baixa quantidade**: Lista produtos cujo estoque está igual ou abaixo de um limite especificado pelo gestor.

### **Operação Contínua**
- O sistema opera em loop, permitindo ao operador iniciar novas vendas ou fechar o caixa a qualquer momento.
- Ao fechar o caixa, o sistema exibe o total de vendas e encerra a execução.

---

## **Tecnologias Utilizadas**
- **Linguagem de Programação**: Java  
- **Paradigma**: Programação Orientada a Objetos (POO)

---

