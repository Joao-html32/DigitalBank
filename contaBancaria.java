public class contaBancaria {

    private String numeroDaConta;
    private String agencia;
    private Cliente titular;
    private double saldo;
    
    public contaBancaria(String numero, Cliente titular, double saldo) {
        this.numeroDaConta = numero;
        this.titular = titular;
        this.saldo = Double.isFinite(saldo) && saldo >= 0 ? saldo : 0;
    }
    public Cliente getTitular() {
        return this.titular;
    }
    public double getSaldo() {
        return this.saldo; 
    }
    public void transferirPix(double valor, contaBancaria contaDestino) {
        if (contaDestino == null) {
            System.out.println("Erro: Conta de destino inválida.");
            return;
        }
        if (Double.isFinite(valor) && valor > 0 && valor <= this.saldo) {
            this.saldo -= valor; 
            contaDestino.depositar(valor);
            System.out.println("Pix de R$ " + valor + " enviado com sucesso para " + contaDestino.getTitular().getNome() + "!");
        } else {
            System.out.println("Erro: Pix recusado! Saldo insuficiente ou valor inválido.");
        }
    }
    public void depositar(double valor) {
        if (Double.isFinite(valor) && valor > 0 && valor <= Double.MAX_VALUE - this.saldo) {
            this.saldo += valor;
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("Erro: Depósito recusado! O valor deve ser positivo.");
        }
    }
    public void sacar(double valor) {
        if (Double.isFinite(valor) && valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso!");
        } else {
            System.out.println("Erro: Saque recusado! Saldo insuficiente ou valor inválido.");
        }
    }
}
