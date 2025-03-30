package br.com.fiap.javacp1.persistence;

import br.com.fiap.javacp1.annotations.Tabela;
import br.com.fiap.javacp1.annotations.Coluna;
import java.lang.reflect.Field;

public class TabelaFuncionario {

    public static String gerarSelectSQL(Object objeto) {
        Class<?> classe = objeto.getClass();
        Tabela anotacaoTabela = obterAnotacaoTabela(classe);

        if (anotacaoTabela == null) {
            throw new IllegalArgumentException("Nenhuma anotação @Tabela encontrada");
        }

        return "SELECT * FROM " + anotacaoTabela.nome();
    }

    public static String gerarInsertSQL(Object objeto) throws IllegalAccessException {
        Class<?> classe = objeto.getClass();
        Tabela anotacaoTabela = obterAnotacaoTabela(classe);

        if (anotacaoTabela == null) {
            throw new IllegalArgumentException("Nenhuma anotação @Tabela encontrada");
        }

        StringBuilder colunas = new StringBuilder();
        StringBuilder valores = new StringBuilder();

        // Percorre todos os campos da hierarquia
        Class<?> currentClass = classe;
        while (currentClass != null) {
            for (Field campo : currentClass.getDeclaredFields()) {
                if (campo.isAnnotationPresent(Coluna.class)) {
                    Coluna anotacaoColuna = campo.getAnnotation(Coluna.class);

                    // Ignora o ID se for gerado automaticamente
                    if (anotacaoColuna.nome().equalsIgnoreCase("ID")) {
                        continue;
                    }

                    campo.setAccessible(true);
                    Object valor = campo.get(objeto);

                    colunas.append(anotacaoColuna.nome()).append(", ");

                    if (valor instanceof Number) {
                        valores.append(valor).append(", ");
                    } else {
                        valores.append(valor != null ? "'" + valor + "'" : "NULL").append(", ");
                    }
                }
            }
            currentClass = currentClass.getSuperclass();
        }

        if (colunas.length() == 0) {
            throw new IllegalArgumentException("Nenhum campo com @Coluna encontrado");
        }

        // Remove a última vírgula
        colunas.setLength(colunas.length() - 2);
        valores.setLength(valores.length() - 2);

        String sqlFinal = String.format("INSERT INTO %s (%s) VALUES (%s)",
                anotacaoTabela.nome(),
                colunas,
                valores);

        System.out.println("SQL Gerado: " + sqlFinal); // Log para depuração
        return sqlFinal;
    }

    private static Tabela obterAnotacaoTabela(Class<?> classe) {
        Tabela anotacaoTabela = classe.getAnnotation(Tabela.class);
        while (anotacaoTabela == null && classe.getSuperclass() != null) {
            classe = classe.getSuperclass();
            anotacaoTabela = classe.getAnnotation(Tabela.class);
        }
        return anotacaoTabela;
    }
}
