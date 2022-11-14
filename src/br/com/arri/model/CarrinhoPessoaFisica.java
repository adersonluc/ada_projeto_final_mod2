package br.com.arri.model;

import br.com.arri.dao.ProdutoDao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
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
        pedidos.stream()
                .filter(pedido -> ProdutoDao.buscarProdutoById(pedido.getIdProduto()).getFrete() == true)
                .collect(Collectors.toList());
    }

    @Override
    public void calculaTaxa(Produto produto, Categoria categoria) {

    }

    @Override
    public void listarItensCarrinho() {
        pedidos.stream().forEach(pedido -> System.out.println(pedido));
        System.out.println();
    }

}
