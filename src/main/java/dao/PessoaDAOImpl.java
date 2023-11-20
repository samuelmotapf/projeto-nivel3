/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import classes.Pessoa;
import db.ConexaoBanco;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author PC
 */
public class PessoaDAOImpl implements PessoaDAO {
    
    private Connection conexao;

    public PessoaDAOImpl() {
        this.conexao = ConexaoBanco.obterConexao();
    }

    @Override
    public void salvar(Pessoa pessoa) {
        try (PreparedStatement stmt = conexao.prepareStatement("INSERT INTO pessoa (nome, email, logradouro, cidade, estado, cpf, cnpj) VALUES (?, ?, ?, ?, ?, ?, ?)")) {
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getEmail());
            stmt.setString(3, pessoa.getLogradouro());
            stmt.setString(4, pessoa.getCidade());
            stmt.setString(5, pessoa.getEstado());
            stmt.setString(6, pessoa.getCpf());
            stmt.setString(7, pessoa.getCnpj());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Trate de forma apropriada em um ambiente real
        }
    }

    @Override
    public void atualizar(Pessoa pessoa) {
        try (PreparedStatement stmt = conexao.prepareStatement("UPDATE pessoa SET nome=?, email=?, logradouro=?, cidade=?, estado=?, cpf=?, cnpj=? WHERE id=?")) {
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getEmail());
            stmt.setString(3, pessoa.getLogradouro());
            stmt.setString(4, pessoa.getCidade());
            stmt.setString(5, pessoa.getEstado());
            stmt.setString(6, pessoa.getCpf());
            stmt.setString(7, pessoa.getCnpj());
            stmt.setInt(8, pessoa.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Trate de forma apropriada em um ambiente real
        }
    }

    @Override
    public void excluir(int id) {
        try (PreparedStatement stmt = conexao.prepareStatement("DELETE FROM pessoa WHERE id=?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Trate de forma apropriada em um ambiente real
        }
    }

    @Override
    public Pessoa buscarPorId(int id) {
        try (PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM pessoa WHERE id=?")) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setId(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setLogradouro(rs.getString("logradouro"));
                pessoa.setCidade(rs.getString("cidade"));
                pessoa.setEstado(rs.getString("estado"));
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setCnpj(rs.getString("cnpj"));
                return pessoa;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Trate de forma apropriada em um ambiente real
        }
        return null;
    }

    @Override
    public List<Pessoa> listarTodos() {
        List<Pessoa> pessoas = new ArrayList<>();
        try (Statement stmt = conexao.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM pessoa");

            while (rs.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setId(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setLogradouro(rs.getString("logradouro"));
                pessoa.setCidade(rs.getString("cidade"));
                pessoa.setEstado(rs.getString("estado"));
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setCnpj(rs.getString("cnpj"));
                pessoas.add(pessoa);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Trate de forma apropriada em um ambiente real
        }
        return pessoas;
    }
}
 

