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
            comando.executeUpdate("INSERT INTO EVENTO(titulo, minimo, data, datasorteio, sorteado) VALUES('" + titulo + "'," + minimo + ", '" + data + "','" + sorteio + "','" + "N" + "')");
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
            ResultSet resultado = comando.executeQuery("SELECT id, nome, email, senha from PARTICIPANTE");
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
            comando.executeUpdate(String.format("INSERT INTO PARTICIPANTE(nome, email, senha) VALUES('%s','%s','%s')", nome, email, senha));
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void updateParticipante(String codigo, String nome, String email, String senha) {
        try {
            Statement comando = conexao.createStatement();
            comando.executeUpdate(String.format("Update PARTICIPANTE set nome = '%s', email = '%s', senha = '%s' where id = " + codigo, nome, email, senha));
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void deleteParticipante(Long id){
        try {
            Statement comando = conexao.createStatement();
            comando.executeUpdate(String.format("DELETE FROM PARTICIPANTE where id=%d", id));
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Participante buscaParticipantes(Long id) {
        Participante participante = new Participante();
        try {
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery(String.format("Select * FROM PARTICIPANTE where id=%d", id));
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
    
    public Evento buscaEvento(Long id) {
        Evento evento = new Evento();
        try {
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery(String.format("Select * FROM EVENTO where id=%d", id));
            while (resultado.next()) {
                evento.setCodigo(resultado.getString("id"));
                evento.setTitulos(resultado.getString("titulo"));
                evento.setData(resultado.getString("data"));
                evento.setSorteio(resultado.getString("datasorteio"));
                evento.setMinimo(Float.parseFloat(resultado.getString("minimo")));
                evento.setSorteado(resultado.getString("sorteado"));
            }
            resultado.close();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return evento;
    }
    
    public Evento listaInscritosEvento(Long idEvento) {
        Evento evento = buscaEvento(idEvento);
        try {
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery("SELECT * from PARTICIPANTE_EVENTO where id_evento = '" + idEvento + "'");
            while (resultado.next()) {
                evento.getInscritos().add(buscaParticipantes(Long.parseLong(resultado.getString("ID_PARTICIPANTE"))));
            }
            resultado.close();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return evento;
    }
    
    void insereNovoInscrito(Long idEvento, Long idParticipante) {
        try {
            int cont = 0;
            Statement comando2 = conexao.createStatement();
            ResultSet resultado = comando2.executeQuery("SELECT * from PARTICIPANTE_EVENTO where id_evento = '" + idEvento + "' and id_Participante = '" + idParticipante + "'");
            while (resultado.next()) {
                cont++;
            }   
            
            if (cont == 0){
                Statement comando = conexao.createStatement();
                comando.executeUpdate(String.format("INSERT INTO PARTICIPANTE_EVENTO(ID_EVENTO, ID_PARTICIPANTE) VALUES('%s','%s')", idEvento, idParticipante));
                comando.close();    
            }
            
            resultado.close();
            comando2.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void deleteInscrito(Long idEvento, Long idInscrito){
        try {
            Statement comando = conexao.createStatement();
            comando.executeUpdate("DELETE FROM PARTICIPANTE_EVENTO where id_participante='" + idInscrito + "' and "
                    + "id_evento='" + idEvento + "'");
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void atualizaSorteados(Long idEvento) {
        try {
            Statement comando = conexao.createStatement();
            comando.executeUpdate(String.format("Update EVENTO set SORTEADO = '" + "S" + "' WHERE id=%d", idEvento));
            comando.close();
            
            /*Statement comando2 = conexao.createStatement();
            comando2.executeUpdate(String.format("Update PARTICIPANTE_EVENTO set ID_AMIGO = '" + idAmigo + "' where idevento = '" + idEvento + "' and id_participante = '" + idParticipante + "'"));
            comando2.close();*/
        } catch (SQLException ex) {
            Logger.getLogger(EventosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Participante buscaAmigo(Long idEvento, Long idParticipante) {
        Participante p = new Participante();
        try {            
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery("SELECT * from PARTICIPANTE_EVENTO where id_evento = '" + idEvento + "' and id_participante = '" + idParticipante + "'");
            while (resultado.next()) {
                p = buscaParticipantes(Long.parseLong(resultado.getString("ID_AMIGO")));
            }
            resultado.close();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    
    public Participante realizaLogin(String email, String senha){
        Participante p = new Participante();
        try {            
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery("SELECT * from PARTICIPANTE where email = '" + email + "' and senha = '" + senha + "'");
            while (resultado.next()) {
                p = buscaParticipantes(Long.parseLong(resultado.getString("ID")));
            }
            resultado.close();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (p.codigo == null){
            p.setCodigo("0");
        }
        return p;    
    }
        
}
