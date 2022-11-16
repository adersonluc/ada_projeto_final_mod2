package br.com.arri.carrinho;

import br.com.arri.carrinho.Carrinho;
import br.com.arri.dao.ProdutoDao;
import br.com.arri.model.Pedido;
import br.com.arri.model.PessoaFisica;
import br.com.arri.model.Produto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CarrinhoPessoaFisica implements Carrinho {

    private PessoaFisica clientePessoaFisica;
    private List<Pedido> pedidos;
    private BigDecimal frete;
    private BigDecimal taxas;

    public CarrinhoPessoaFisica(PessoaFisica cliente) {
        this.clientePessoaFisica = cliente;
        this.pedidos = new ArrayList<>();
    }

    @Override
    public void adicionarProduto(Produto produto) {
        Boolean isProdutoInPedidos = false;
        for(Pedido pedido : pedidos) {
            if (pedido.getIdProduto().equals(produto.getId())) {
                isProdutoInPedidos = true;
                pedido.setQuantidadeProduto(pedido.getQuantidadeProduto() + 1);
                pedido.setPrecoTotal(new BigDecimal(pedido.getQuantidadeProduto()).multiply(produto.getPrecoUnitario()));
                break;
            }
        }
        if(!isProdutoInPedidos){
            pedidos.add(new Pedido(new Random().nextInt(), produto.getId(), 1, produto.getPrecoUnitario()));
        }
    }

    @Override
    public void removerProduto(Produto produto) {
        pedidos.remove(pedidos.stream()
                .filter(pedido -> pedido.getIdProduto().equals(produto.getId())).collect(Collectors.toList()).get(0));
    }

    @Override
    public void alterarQuantidade(Integer quantidade, Produto produto) {
        if(quantidade <= 0){
            System.out.println("Quantidade inválida.");
        } else{
            pedidos.forEach(pedido -> {
                if(pedido.getIdProduto().equals(produto.getId())){
                    pedido.setQuantidadeProduto(quantidade);
                    pedido.setPrecoTotal(new BigDecimal(pedido.getQuantidadeProduto()).multiply(produto.getPrecoUnitario()));
                }
            });
        }
    }

    @Override
    public void calcularFrete() {
        ProdutoDao produtoDao = new ProdutoDao();
        BigDecimal valorTotalCarrinho = pedidos.stream()
                .filter(pedido -> produtoDao.buscarById(pedido.getIdProduto()).getFrete() == true)
                .map(pedido -> pedido.getPrecoTotal())
                .reduce(new BigDecimal("0.00"), (numeroAnterior, numeroAtual) -> numeroAnterior.add(numeroAtual));
        this.frete = valorTotalCarrinho.multiply(new BigDecimal("0.008"));
    }

    @Override
    public void calculaTaxa() {
        ProdutoDao produtoDao = new ProdutoDao();
        this.taxas = pedidos.stream()
                .map(pedido -> produtoDao.buscarById(pedido.getIdProduto()).getCategoria().valorTaxa().multiply(pedido.getPrecoTotal()))
                .reduce(new BigDecimal("0.00"), (valorAnterior, valorAtual) -> valorAnterior.add(valorAtual));
    }

    @Override
    public void listarItensCarrinho() {
        ProdutoDao produtoDao = new ProdutoDao();
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Dados do Cliente");
        System.out.println("Nome: " + this.clientePessoaFisica.getNome());
        System.out.println("E-mail: " + this.clientePessoaFisica.getEmail());
        System.out.println("Telefone: " + this.clientePessoaFisica.getTelefone());
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Produtos                       Categoria       Preço Unitário      Quantidade          Preço Total         Taxa do Produto  ");
        this.pedidos.stream()
                .forEach(pedido -> {
                    Produto produtoPedido = produtoDao.buscarById(pedido.getIdProduto());
                    System.out.printf("%-30s", produtoPedido.getNome());
                    System.out.printf("%-20s", produtoPedido.getCategoria());
                    System.out.printf("R$ %-19.2f", produtoPedido.getPrecoUnitario());
                    System.out.printf("%-14d ", pedido.getQuantidadeProduto());
                    System.out.printf("R$ %-20.2f", pedido.getPrecoTotal());
                    System.out.printf("R$ %-20.2f\n", pedido.getPrecoTotal().multiply(produtoPedido.getCategoria().valorTaxa()));
                });
        BigDecimal valorTotalCompra = this.pedidos.stream()
                .map(pedido -> pedido.getPrecoTotal())
                .reduce(new BigDecimal("0.00"), (valorAnterior, valorAtual) -> valorAnterior.add(valorAtual));

        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("\nValor Total da Compra: R$ %.2f\n", valorTotalCompra);
        System.out.printf("\nValor Total do Frete: R$ %.2f\n", this.frete);
        System.out.printf("\nValor Total das Taxas: R$ %.2f\n", this.taxas);
        System.out.printf("\nValor Total da Compra com frete e taxas: R$ %.2f\n", (valorTotalCompra.add(this.frete)).add(this.taxas));
    }

}