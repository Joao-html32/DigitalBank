import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {

    public void salvar(Cliente cliente) {
        String sql = "INSERT INTO clientes (nome, cpf, data_nascimento, celular) VALUES (?, ?, ?, ?)";

        
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
        
           
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCPF()); 
            stmt.setObject(3, cliente.getDataDeNascimento());
            stmt.setString(4, cliente.getCelular());

            
            stmt.executeUpdate();
            System.out.println("Cliente salvo com sucesso no banco de dados!");
        
        } catch (SQLException e) {
            System.out.println("Erro ao salvar o cliente: " + e.getMessage());
        }
    }
}
