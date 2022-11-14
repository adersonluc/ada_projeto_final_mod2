package br.com.arri.model;

import br.com.arri.dao.ProdutoDao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class CarrinhoPessoaFisica implements Carrinho{

    private List<Pedido> pedidos;
    private BigDecimal frete;
    private BigDecimal taxas;

    public CarrinhoPessoaFisica() {
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
        pedidos.remove(pedidos.stream().filter(pedido -> pedido.getIdProduto().equals(produto.getId())).collect(Collectors.toList()).get(0));
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
        Optional<BigDecimal> valorTotalCarrinho = pedidos.stream()
                .filter(pedido -> ProdutoDao.buscarProdutoById(pedido.getIdProduto()).getFrete() == true)
                .map(pedido -> pedido.getPrecoTotal()).collect(Collectors.toList())
                .stream().reduce((numeroAnterior, numeroAtual) -> numeroAnterior.add(numeroAtual));
        this.frete = valorTotalCarrinho.get().multiply(new BigDecimal("0.005"));
    }

    @Override
    public void calculaTaxa() {
        this.taxas = pedidos.stream()
                .map(pedido -> ProdutoDao.buscarProdutoById(pedido.getIdProduto()).getCategoria().valorTaxa().multiply(pedido.getPrecoTotal()))
                .collect(Collectors.toList())
                .stream().reduce(new BigDecimal("0.00"), (valorAnterior, valorAtual) -> valorAnterior.add(valorAtual));
        System.out.println(this.taxas);
    }

    @Override
    public void listarItensCarrinho() {
        pedidos.stream().forEach(pedido -> System.out.println(pedido));
        System.out.println();
    }

}
