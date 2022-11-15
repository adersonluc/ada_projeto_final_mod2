package br.com.arri.model;

public class PessoaJuridica extends Pessoa{

    private String nomeFantasia;
    private String cnpj;

    public PessoaJuridica(Integer id, String nome, String email, String telefone, Endereco endereco, String nomeFantasia, String cnpj) {
        super(id, nome, email, telefone, endereco);
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
