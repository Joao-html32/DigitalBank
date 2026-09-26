import java.time.LocalDate;

public class Cliente {
   
    private String nome;
    private String CPF;
    private LocalDate dataDeNascimento;
    private String celular;

    public Cliente(String nome, String CPF, LocalDate dataDeNascimento, String celular) {
        this.nome = nome;
        this.CPF = CPF;
        this.dataDeNascimento = dataDeNascimento;
        this.celular = celular;
    }
    public String getNome() {
        return this.nome;
    }
    public String getCPF() {
        return this.CPF;
    }
    public LocalDate getDataDeNascimento() {
        return this.dataDeNascimento;
    }
    public String getCelular() {
        return this.celular;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
