# 🏦 Itaú Digital Bank - Core Bancário em Java

Este projeto simula o módulo central de controle e movimentação de contas de um banco digital. O objetivo principal foi desenvolver uma estrutura de back-end altamente segura, simulando regras de negócio reais do setor financeiro.

---

## 🛠️ Conceitos de POO Aplicados

Durante o desenvolvimento deste módulo, apliquei conceitos fundamentais de **Programação Orientada a Objetos** para garantir a segurança dos dados:

* **Encapsulamento e Visibilidade:** Todos os atributos críticos (como `saldo`, `titular` e `numeroDaConta`) foram definidos como `private`. Isso garante que nenhuma classe externa possa modificar o saldo diretamente, protegendo o sistema contra fraudes.
* **Métodos Especiais (Getters):** Implementação do método público `getSaldo()`. Isso permite que o mundo externo consulte o saldo da conta de forma segura (apenas leitura).
* **Métodos Construtores:** Criação de um construtor personalizado para inicializar o objeto da conta com os parâmetros obrigatórios exigidos pelo banco (`numero`, `nomeDoTitular`, `saldo`).

---

## 🛑 Regras de Negócio e Segurança

Para aproximar o projeto da realidade técnica de um banco como o Itaú, foram implementadas as seguintes validações:

1. **Validação de Saque:** O método `sacar(double valor)` avalia se o cliente possui fundos suficientes (`valor <= saldo`) e impede que a conta fique com saldo negativo.
2. **Validação de Valores Positivos:** O sistema garante que operações de saque e depósito só ocorram se o valor inserido for maior que zero (`valor > 0`), impedindo tentativas de burlar o saldo com valores inválidos.

---

## 📂 Estrutura do Projeto

O projeto foi dividido de forma profissional em dois arquivos separados para respeitar a divisão de responsabilidades:

* `contaBancaria.java`: Contém o molde (classe), os atributos privados, o construtor e os métodos de negócio (`sacar`, `depositar`, `getSaldo`).
* `digitalBank.java`: Classe principal (executora) que contém o método `main` para rodar os testes e simular as transações no terminal.

---

## 🚀 Como Executar

1. Certifique-se de ter o Java JDK instalado na sua máquina.
2. Compile e execute o arquivo `digitalBank.java`.
3. O terminal exibirá o fluxo completo de criação de conta, bloqueio de saque por saldo insuficiente, depósito e saque bem-sucedido.
