package com.mycompany.exercicio3;

import classes.Pessoa;
import dao.PessoaDAO;
import dao.PessoaDAOImpl;
import java.util.List;

public class Exercicio3 {

    public static void main(String[] args) {
        PessoaDAO pessoaDAOimpl = new PessoaDAOImpl();

        try {
            System.out.println("Cadastrando!");
            // Teste de salvar
            Pessoa novaPessoa = new Pessoa();
            novaPessoa.setNome("Fulano");
            novaPessoa.setEmail("fulano@email.com");
            novaPessoa.setLogradouro("Rua A");
            novaPessoa.setCidade("Cidade B");
            novaPessoa.setEstado("Estado X");
            novaPessoa.setCpf("123.456.789-00");
            novaPessoa.setCnpj("12.345.678/0001-90");

            pessoaDAOimpl.salvar(novaPessoa);

            System.out.println("Cadastrado com sucesso!");

            System.out.println("Cadastrando 2!");

            // Teste de listar todos
            List<Pessoa> pessoas = pessoaDAOimpl.listarTodos();
            for (Pessoa pessoa : pessoas) {
                System.out.println("ID: " + pessoa.getId() + ", Nome: " + pessoa.getNome() + ", Email: " + pessoa.getEmail() +
                                   ", Logradouro: " + pessoa.getLogradouro() + ", Cidade: " + pessoa.getCidade() +
                                   ", Estado: " + pessoa.getEstado() + ", CPF: " + pessoa.getCpf() + ", CNPJ: " + pessoa.getCnpj());
            }

            System.out.println("Listagem concluída!");
        } catch (Exception e) {
            System.err.println("Erro durante a execução do teste: " + e.getMessage());
            e.printStackTrace(); // Isso imprimirá o rastreamento completo da exceção no console
        }
    }
}
