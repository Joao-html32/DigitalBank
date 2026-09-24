# 🏦 DigitalBank - Core Bancário em Java & Persistência SQL

Este projeto simula o núcleo de processamento e controle de um banco digital moderno. A aplicação combina regras de negócio robustas em **Java** com persistência de dados em **SQL (MySQL)**, utilizando padrões de arquitetura de mercado para garantir alta disponibilidade, segurança e integridade transacional.

---

## 🏗️ Arquitetura do Projeto & Padrões de Mercado

Para afastar as regras de negócio das consultas de banco de dados e manter o sistema escalável, o projeto foi estruturado seguindo os padrões mais consolidados do mercado backend:

* **Data Access Object (DAO):** Implementado na classe `ClienteDAO.java` para isolar completamente os comandos SQL de inserção e manipulação de dados.
* **Connection Factory:** Centralização da abertura e fechamento de conexões com o banco de dados na classe `ConnectionFactory.java`, protegendo o ciclo de vida da aplicação contra vazamento de recursos.
* **Segurança e Variáveis de Ambiente:** Armazenamento centralizado de constantes e chaves de acesso na classe `Protect.java`, utilizando o padrão de fallback `System.getenv().getOrDefault(...)` para blindar credenciais locais.
* **Encapsulamento Rígido:** Atributos cruciais como saldos, CPFs e dados de cadastro usam modificadores privados, impedindo a adulteração de estados fora dos métodos autorizados.

---

## ⚡ Funcionalidades e Regras de Negócio Financeiras

1. **Transferência via Pix:** O método `transferirPix` garante a movimentação atômica de saldos entre contas de origem e destino, validando limites e impedindo fraudes na memória.
2. **Camada de Persistência Segura:** Uso de `PreparedStatement` com parâmetros parametrizados (`?`) contra ataques de *SQL Injection*.
3. **Gerenciamento de Recursos Automatizado:** Utilização de blocos `try-with-resources` no Java para garantir o fechamento imediato de conexões e instruções após a execução.
4. **Proteção de Overflow:** Validações com `Double.isFinite()` e checagens matemáticas contra estouro de limite físico de saldo (`Double.MAX_VALUE`).

---

## 🗄️ Modelagem do Banco de Dados Relacional (MySQL)

A inteligência dos dados está estruturada em scripts relacionais otimizados:
* **Tabelas com Integridade Referencial:** Configuração de chaves estrangeiras (`FOREIGN KEY`) conectando Clientes, Contas Bancárias e Históricos.
* **Stored Procedures:** Criação do procedimento armazenado `pr_realizar_transferencia` para executar de maneira nativa, performática e segura os débitos, créditos e auditorias direto no servidor de banco de dados.

---

## 📂 Estrutura de Arquivos Atualizada

* `Cliente.java`: Entidade de modelo encapsulada contendo as regras cadastrais.
* `ContaBancaria.java`: Lógica financeira central (saques, depósitos e Pix).
* `ConnectionFactory.java`: Fábrica isolada para gerenciamento seguro do JDBC.
* `ClienteDAO.java`: Ponte de persistência responsável por inserir registros no MySQL.
* `Protect.java`: Central de isolamento de constantes SQL e credenciais de infraestrutura.
* `DigitalBank.java`: Classe principal executável para simulação e testes do ecossistema.
* `estrutura.sql`: Script de mapeamento DDL das tabelas relacionais.
* `procedimentos.sql`: Automatização de transações financeiras via Stored Procedures.

---

## 🚀 Como Executar

1. Certifique-se de possuir o Java JDK e um servidor MySQL configurados.
2. Execute o script `estrutura.sql` e `procedimentos.sql` no seu servidor de banco de dados local.
3. Configure as credenciais na classe de segurança (`Protect.java`) ou por variáveis de ambiente.
4. Execute a classe principal `DigitalBank.java` no seu terminal para disparar as rotinas integradas.
