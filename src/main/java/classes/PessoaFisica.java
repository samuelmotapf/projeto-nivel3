/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author PC
 */
public class PessoaFisica extends Pessoa {
    private String cpf;

    public PessoaFisica() {
        super();
    }

    public PessoaFisica(int id, String nome, String logradouro, String cidade, String estado, String email, String cpf) {
        
        this.cpf = cpf;
    }

    // Getters e Setters para o campo cpf
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // Sobrescrever o método exibir() para mostrar informações específicas de PessoaFisica
     
    public void exibir() {
        System.out.println("Informações da Pessoa Física:");
        System.out.println("ID: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("Logradouro: " + getLogradouro());
        System.out.println("Cidade: " + getCidade());
        System.out.println("Estado: " + getEstado());
        System.out.println("Email: " + getEmail());
        System.out.println("CPF: " + getCpf());
    }
}