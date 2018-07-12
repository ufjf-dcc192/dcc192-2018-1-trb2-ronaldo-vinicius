package codigos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
    
    public List<Evento> listEventos() {
        List<Evento> eventos = new ArrayList<>();
        try {
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery("SELECT id, titulo, minimo, datasorteio, data from EVENTO");
            while (resultado.next()) {
                Evento evento = new Evento();
                evento.setCodigo(resultado.getString("id"));
                evento.setTitulos(resultado.getString("titulo"));
                evento.setMinimo(Float.parseFloat(resultado.getString("minimo")));
                evento.setData(resultado.getString("data"));
                evento.setSorteio(resultado.getString("datasorteio"));
                eventos.add(evento);

            }
            resultado.close();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return eventos;
    }
    
    void createEvento(String titulo, Float minimo, String sorteio) throws ParseException {
        try {  
            Calendar calendar = Calendar.getInstance();
            java.sql.Date sqlDate = new java.sql.Date(calendar.getTime().getTime());
            SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy"); 
            String data = out.format(sqlDate);
            
            sorteio = out.format(Date.valueOf(sorteio));
            
            Statement comando = conexao.createStatement();
            comando.executeUpdate("INSERT INTO EVENTO(titulo, minimo, data, datasorteio) VALUES('" + titulo + "'," + minimo + ", '" + data + "','" + sorteio + "')");
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void deleteEvento(Long id){
        try {
            Statement comando = conexao.createStatement();
            comando.executeUpdate(String.format("DELETE FROM EVENTO WHERE id=%d", id));
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public List<Participante> listParticipantes() {
        List<Participante> participantes = new ArrayList<>();
        try {
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery("SELECT id, nome, email, senha from PARTICPANTE");
            while (resultado.next()) {
                Participante participante = new Participante();
                participante.setCodigo(resultado.getString("id"));
                participante.setNome(resultado.getString("nome"));
                participante.setEmail(resultado.getString("email"));
                participante.setSenha(resultado.getString("senha"));
                participantes.add(participante);
            }
            resultado.close();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return participantes;
    }
    
    void createParticipante(String nome, String email, String senha) {
        try {
            Statement comando = conexao.createStatement();
            comando.executeUpdate(String.format("INSERT INTO PARTICPANTE(nome, email, senha) VALUES('%s','%s','%s')", nome, email, senha));
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void updateParticipante(String codigo, String nome, String email, String senha) {
        try {
            Statement comando = conexao.createStatement();
            comando.executeUpdate(String.format("Update PARTICPANTE set nome = '%s', email = '%s', senha = '%s' where id = " + codigo, nome, email, senha));
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void deleteParticipante(Long id){
        try {
            Statement comando = conexao.createStatement();
            comando.executeUpdate(String.format("DELETE FROM PARTICPANTE where id=%d", id));
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Participante buscaParticipantes(Long id) {
        Participante participante = new Participante();
        try {
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery(String.format("Select * FROM PARTICPANTE where id=%d", id));
            while (resultado.next()) {
                participante.setCodigo(resultado.getString("id"));
                participante.setNome(resultado.getString("nome"));
                participante.setEmail(resultado.getString("email"));
                participante.setSenha(resultado.getString("senha"));
            }
            resultado.close();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return participante;
    }
}
