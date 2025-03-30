# Sistema de Gestão de Funcionários

## Introdução
Este projeto implementa um sistema de gestão de funcionários com diferentes níveis hierárquicos. Utilizamos conceitos avançados de orientação a objetos, como herança, e tecnologias modernas para persistência de dados e geração dinâmica de consultas SQL.

## Funcionalidades
- Cadastro de funcionários com diferentes níveis hierárquicos (Estagiário, Júnior, Pleno, Sênior e Especialista);
- Cálculo de salários com regras específicas para cada cargo;
- Listagem de funcionários cadastrados no banco de dados;
- Atualização e remoção de registros;
- Geração dinâmica de SQL utilizando Reflection.

## Tecnologias Utilizadas
| Tecnologia      | Finalidade |
|----------------|------------|
| **Java 17**    | Linguagem principal do projeto |
| **JPA 3.1**    | API de persistência de dados |
| **Hibernate 6.4** | Implementação do JPA |
| **Oracle 21c** | Banco de dados relacional |
| **Maven**      | Gerenciamento de dependências |
| **IntelliJ IDEA** | IDE para desenvolvimento |

## Estrutura do Banco de Dados
O sistema utiliza uma única tabela `TAB_FUNCIONARIO` com os seguintes campos:

| Coluna            | Tipo             | Descrição |
|------------------|----------------|------------|
| `ID`            | `NUMBER`        | Chave primária autoincremento |
| `NOME`          | `VARCHAR2(255)` | Nome do funcionário |
| `HORAS_TRABALHADAS` | `NUMBER`     | Horas trabalhadas no mês |
| `VALOR_POR_HORA` | `NUMBER(19,2)` | Valor da hora trabalhada |
| `TIPO_FUNCIONARIO` | `VARCHAR2(20)` | Cargo do funcionário |

## Exemplo de Uso
Cadastro de um Sênior no banco de dados:

```java
Senior senior = new Senior("Maria", 45, 80.0);
EntityManager em = emf.createEntityManager();
em.getTransaction().begin();
em.persist(senior);
em.getTransaction().commit();
```

Saída esperada no banco de dados:

| ID | NOME  | HORAS | VALOR_HORA | TIPO_FUNCIONARIO |
|----|-------|------|------------|----------------|
| 1  | Maria | 45   | 80.0       | SENIOR        |

## Como Rodar o Projeto
1. Clone o repositório:
   ```sh
   git clone https://github.com/seu-usuario/seu-repositorio.git
   ```
2. Importe o projeto no IntelliJ IDEA.
3. Configure o banco de dados Oracle e ajuste as credenciais no arquivo `persistence.xml`.
4. Execute a classe `MainMenu` para interagir com o sistema via console.

## Criadores
- **João Paulo Moreira dos Santos** - RM 557808
- **Arthur Bispo de Lima** - RM 557568

**Curso:** Análise e Desenvolvimento de Sistemas - 2TDSPV

## Melhorias Futuras
- Implementação de validação de dados;
- Criação de testes unitários;
- Desenvolvimento de uma interface gráfica;
- Geração automática de relatórios.

## Licença
Este projeto é de uso acadêmico e não possui uma licença específica.

