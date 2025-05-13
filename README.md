# Aula 8 – CRUD com Java Swing e MySQL

Este projeto foi criado em sala de aula com o objetivo de apresentar conceitos fundamentais de desenvolvimento de interfaces gráficas com **Java Swing**, integração com **banco de dados MySQL**, e aplicação do padrão de arquitetura **MVC (Model-View-Controller)**.

---

## 📌 Objetivos do Projeto

- Aplicar o padrão de desenvolvimento **CRUD** (Create, Read, Update, Delete)
- Desenvolver interfaces com **Java Swing**
- Utilizar **MySQL** como sistema de gerenciamento de banco de dados
- Integrar Java com MySQL utilizando **JDBC**
- Aplicar o padrão **MVC** para organização do código
- Utilizar o **NetBeans** como IDE para desenvolvimento

---

## 🧱 Estrutura MVC no Projeto

O projeto adota o padrão **Model-View-Controller**, separando as responsabilidades da aplicação em três camadas:

- **Model**: Representa os dados e interage com o banco (ex: `ProdutoModel`)
- **View**: Interface gráfica com o usuário (ex: `ProdutoView`)
- **Controller**: Controla as ações do usuário e coordena a comunicação entre Model e View (ex: `ProdutoController`)

---

## ⚙️ Tecnologias Utilizadas

- **Java SE 8+**
- **Java Swing**
- **MySQL 5.7+**
- **NetBeans IDE**
- **JDBC (Java Database Connectivity)**

---

## 🔧 Dependências

Este projeto utiliza a seguinte biblioteca externa:

### 📁 mysql-connector-java-8.0.27.jar

- Arquivo: `lib/mysql-connector-java-8.0.27.jar`
- Origem: [https://dev.mysql.com/downloads/connector/j/](https://dev.mysql.com/downloads/connector/j/)
- Finalidade: Estabelecer conexão JDBC com o banco de dados MySQL

#### ➕ Como adicionar ao projeto (NetBeans):

1. Copie o arquivo `mysql-connector-java-8.0.27.jar` para uma pasta `lib/` no seu projeto
2. No NetBeans, clique com o botão direito no projeto → **Propriedades**
3. Vá em **Bibliotecas → Compile**
4. Clique em **"Adicionar JAR/Pasta"**
5. Selecione o arquivo na pasta `lib/` e confirme

> ⚠️ Certifique-se de que o `.jar` está incluído em seu classpath de execução.

---

## 🛠️ Funcionalidades

- Cadastro de Produtos
- Listagem de todos os produtos
- Inclusão de novo produto
- Edição de produto existente
- Exclusão de produto
- Interface gráfica com validações

---

## 🗃️ Estrutura da Tabela `produto`

```sql
CREATE TABLE produto (
  id INT PRIMARY KEY AUTO_INCREMENT,
  descricao VARCHAR(100),
  estoque INT,
  valor DECIMAL(10,2)
);
