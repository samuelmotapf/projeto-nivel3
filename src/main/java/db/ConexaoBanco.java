/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class ConexaoBanco {

    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=exercicio3";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    public static Connection obterConexao() {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao obter a conexão com o banco de dados: " + e.getMessage());
        }
    }
}
