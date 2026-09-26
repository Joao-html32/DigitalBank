public final class Protect {
    
    private Protect() {
    }

   
    public static final String CREATE_CLIENTES_TABLE =
            "CREATE TABLE clientes ("
                    + "id_cliente INT AUTO_INCREMENT PRIMARY KEY, "
                    + "nome VARCHAR(100), "
                    + "cpf VARCHAR(11), "
                    + "data_nascimento DATE, "
                    + "celular VARCHAR(15)"
                    + ")";

    
    public static final String DB_URL = "jdbc:mysql://localhost:3306/digital_bank";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "kikolokokiko";
}
