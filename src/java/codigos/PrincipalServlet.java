package codigos;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "PrincipalServlet", urlPatterns = {"/index.html", "/eventos.html", "/novoevento.html", 
                                                    "/inscricao.html", "/inscritos.html", "/amigo.html",
                                                    "/participantes.html", "/novoParticipante.html", "/editaParticipante.html", "/excluiParticipante.html",
                                                    "/listaInscritos.html", "/novoInscrito.html", "/selecionarInscrito.html", "/excluiInscrito.html",
                                                    "/sortearEvento.html", "/login.html", "/login_erro.html"})
public class PrincipalServlet extends HttpServlet {

        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String, String> rotas = new HashMap<>();
        
        rotas.put("/index.html", "codigos.IndexCommand");
        rotas.put("/novoevento.html", "codigos.NovoEventoCommand");
        rotas.put("/inscricao.html", "codigos.InscricaoEventoCommand");
        rotas.put("/inscritos.html", "codigos.ListarInscritosEventoCommand");
        
        rotas.put("/participantes.html", "codigos.ListarParticipantesCommand");
        rotas.put("/novoParticipante.html", "codigos.NovoParticipanteCommand");
        rotas.put("/editaParticipante.html", "codigos.EditaParticipanteCommand");
        
        rotas.put("/listaInscritos.html", "codigos.ListarInscritosEventoCommand");
        rotas.put("/novoInscrito.html", "codigos.NovoInscritoCommand");  
       
        rotas.put("/login.html", "codigos.LoginCommand");
        
        
        
        String clazzName = rotas.get(request.getServletPath());
        try {
            Comando comando = (Comando) Class.forName(clazzName).newInstance();
            comando.exec(request, response);
        } catch (ClassNotFoundException|IllegalAccessException|InstantiationException ex) {
            response.sendError(500, "Erro: "+ex);
            Logger.getLogger(PrincipalServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String, String> rotas = new HashMap<>();
        rotas.put("/index.html", "codigos.DeletaEventoCommandPost");
        rotas.put("/novoParticipante.html", "codigos.NovoParticipanteCommandPost");
        rotas.put("/editaParticipante.html", "codigos.EditaParticipanteCommandPost");
        rotas.put("/excluiParticipante.html", "codigos.DeletaParticipanteCommandPost");
        
        rotas.put("/novoevento.html", "codigos.NovoEventoCommandPost");
        
        rotas.put("/inscricao.html", "codigos.InscricaoEventoCommand");
        rotas.put("/amigo.html", "codigos.VerAmigoOcultoCommand");
        
        rotas.put("/selecionarInscrito.html", "codigos.SelecionarInscritoCommandPost");
        rotas.put("/excluiInscrito.html", "codigos.DeletaInscritoCommandPost");    
        
        rotas.put("/sortearEvento.html", "codigos.SortearEventoCommandPost");   
        
        rotas.put("/amigo.html", "codigos.LoginCommandPost");
        
        
        String clazzName = rotas.get(request.getServletPath());
        try {
            Comando comando = (Comando) Class.forName(clazzName).newInstance();
            comando.exec(request, response);
        } catch (ClassNotFoundException|IllegalAccessException|InstantiationException ex) {
            response.sendError(500, "Erro: "+ex);
            Logger.getLogger(PrincipalServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
