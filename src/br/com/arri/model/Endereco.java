package br.com.arri.model;

public class Endereco {

    private String logradouro;
    private String complemento;
    private Integer numero;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;

    public Endereco(String logradouro, String complemento, Integer numero, String bairro, String cep, String cidade, String uf) {
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString(){
        return (this.logradouro + ", " + this.numero + ", " + this.complemento + "\n" +
                this.bairro + "\n" + this.cidade + "-" + this.uf + "\n" + this.cep);
    }

}
