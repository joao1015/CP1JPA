
package br.com.fiap.javacp1.annotations;

import java.lang.annotation.*;

@Inherited // Adicione esta linha
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Tabela {
    String nome();
}