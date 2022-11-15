package br.com.arri.model;

import java.time.LocalDateTime;

public class PessoaFisica extends Pessoa{

    private String nomeSocial;
    private String sexo;
    private LocalDateTime dtNascimento;
    private String cpf;

    public PessoaFisica(Integer id, String nome, String email, String telefone, Endereco endereco, String nomeSocial, String sexo, LocalDateTime dtNascimento, String cpf) {
        super(id, nome, email, telefone, endereco);
        this.nomeSocial = nomeSocial;
        this.sexo = sexo;
        this.dtNascimento = dtNascimento;
        this.cpf = cpf;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDateTime getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(LocalDateTime dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
