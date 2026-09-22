# 🏦 DigitalBank - Core Bancário em Java

Este projeto simula o núcleo de controle de contas de um banco digital, focando em segurança, regras de negócio financeiras e arquitetura robusta.

## 🛠️ Conceitos de POO Aplicados

- **Encapsulamento Rígido:** Atributos como `saldo`, `titular` e `numeroDaConta` são privados para blindar o sistema contra alterações indevidas.
- **Métodos Acessores e Construtores:** Garantem acesso seguro às informações (somente leitura) e impedem a criação de objetos inválidos.

## ⚡ Funcionalidades de Mercado Implementadas

1. **Transferência via Pix:** Método `transferirPix` garante a atomicidade entre contas de origem e destino.
2. **Validações de Segurança:** Uso de `Double.isFinite()` contra valores inválidos e prevenção de estouro de memória (`Double.MAX_VALUE`).

## 📂 Estrutura do Projeto

- `ContaBancaria.java`: Modelo, atributos encapsulados e regras de movimentação.
- `DigitalBank.java`: Classe principal com o método `main` para simulação de fluxo.

## 🚀 Como Executar

1. Tenha o Java JDK instalado.
2. Compile e execute `DigitalBank.java` para ver o fluxo no terminal.
