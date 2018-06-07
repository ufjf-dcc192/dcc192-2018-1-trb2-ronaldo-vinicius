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



@WebServlet(name = "PrincipalServlet", urlPatterns = {"/index.html", "/eventos.html", "/novoevento.html", "/inscricao.html", "/inscritos.html", "/amigo.html"})
public class PrincipalServlet extends HttpServlet {

        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String, String> rotas = new HashMap<>();
        
        rotas.put("/index.html", "codigos.IndexCommand");
        rotas.put("/eventos.html", "codigos.ListarEventosCommand");
        rotas.put("/novoevento.html", "codigos.NovoEventoCommand");
        rotas.put("/inscricao.html", "codigos.InscricaoEventoCommand");
        rotas.put("/inscritos.html", "codigos.ListarInscritosEventoCommand");
        
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
        rotas.put("/eventos.html", "codigos.ListarEventosCommand");
        rotas.put("/novoevento.html", "codigos.NovoEventoCommandPost");
        rotas.put("/inscricao.html", "codigos.InscricaoEventoCommand");
        rotas.put("/amigo.html", "codigos.VerAmigoOcultoCommand");
        
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
