package codigos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EventosDAO {
    private static Connection conexao;
    private static EventosDAO instancia;

    public static EventosDAO getInstance() {
        if (instancia == null) {
            instancia = new EventosDAO();
        }
        return instancia;
    }

    public EventosDAO() {
        try {
            if (conexao == null) {
                conexao = DriverManager.getConnection("jjdbc:derby://localhost:1527/AmigoOculto", "usuario", "senha");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
