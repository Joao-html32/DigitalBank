import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.SQLException;

public class ContaDAO {

    public void transferirPix(int idOrigem, int idDestino, BigDecimal valor) {
        String sql = "{call pr_realizar_pix(?, ?, ?)}";

        try (Connection conn = ConnectionFactory.getConnection();
             CallableStatement callableStmt = conn.prepareCall(sql)) {

            callableStmt.setInt(1, idOrigem);
            callableStmt.setInt(2, idDestino);
            callableStmt.setBigDecimal(3, valor);

            callableStmt.execute();
            System.out.println("Pix realizado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao realizar transação Pix: " + e.getMessage());
        }
    } 

   
    public void exibirExtrato(int idConta) {
        String sql = "SELECT id_transacao, id_conta_origem, id_conta_destino, valor, data_transacao " +
                     "FROM transacoes WHERE id_conta_origem = ? OR id_conta_destino = ? " +
                     "ORDER BY data_transacao DESC";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

         
            stmt.setInt(1, idConta);
            stmt.setInt(2, idConta);

           
            try (ResultSet rs = stmt.executeQuery()) {
                System.out.println("\n========== EXTRATO BANCÁRIO (CONTA " + idConta + ") ==========");
                
                boolean temTransacao = false;

               
                while (rs.next()) {
                    temTransacao = true;
                    int origem = rs.getInt("id_conta_origem");
                    int destino = rs.getInt("id_conta_destino");
                    BigDecimal valorTransacao = rs.getBigDecimal("valor");
                    String data = rs.getString("data_transacao");

                  
                    if (origem == idConta) {
                        System.out.println("[SAÍDA] Data: " + data + " | Para Conta: " + destino + " | Valor: -R$ " + valorTransacao);
                    } 
               
                    else {
                        System.out.println("[ENTRADA] Data: " + data + " | De Conta: " + origem + " | Valor: +R$ " + valorTransacao);
                    }
                }

                if (!temTransacao) {
                    System.out.println("Nenhuma transação encontrada para esta conta.");
                }
                System.out.println("==================================================\n");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar o extrato: " + e.getMessage());
        }
    } 
}
