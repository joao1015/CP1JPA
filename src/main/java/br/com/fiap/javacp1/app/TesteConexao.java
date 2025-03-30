package br.com.fiap.javacp1.app;

import java.sql.Connection;
import java.sql.DriverManager;

public class TesteConexao {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@Oracle.fiap.com.br:1521/orcl";
        try (Connection conn = DriverManager.getConnection(url, "rm557808", "021093")) {
            System.out.println("Conexão bem-sucedida!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}