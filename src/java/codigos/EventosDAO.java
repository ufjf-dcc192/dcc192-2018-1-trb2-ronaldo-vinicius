package codigos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
                conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/AmigoOculto", "usuario", "senha");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Evento> listAll() {
        List<Evento> tarefas = new ArrayList<>();
        try {
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery("SELECT id, data, titulo from EVENTO");
            while (resultado.next()) {
                Evento evento = new Evento();
                evento.setCodigo(resultado.getString("id"));
                evento.setTitulos(resultado.getString("titulo"));
                tarefas.add(evento);

            }
            resultado.close();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tarefas;
    }
}
