public class contaBancaria {

    private String numeroDaConta;
    private String titular;
    private double saldo;
    
    public contaBancaria(String numero, String nomeDoTitular, double saldo) {
        this.numeroDaConta = numero;
        this.titular = nomeDoTitular;
        this.saldo = saldo;
       
    }
     public double getSaldo() {
        return this.saldo; 
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }
    public void sacar(double valor) {

        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
        } else {
            System.out.println("Erro: Saque recusado! Saldo insuficiente ou valor inválido.");
        }
    }
    }
