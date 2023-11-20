/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import classes.Pessoa;
import java.util.List;
/**
 *
 * @author PC
 */
public interface PessoaDAO {
    void salvar(Pessoa usuario);
    void atualizar(Pessoa usuario);
    void excluir(int id);
    Pessoa buscarPorId(int id);
    List<Pessoa> listarTodos();
}
