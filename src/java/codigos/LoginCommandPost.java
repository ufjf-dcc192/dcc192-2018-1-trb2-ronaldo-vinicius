package codigos;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginCommandPost implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/eventos/amigo.jsp");        
        Participante participante = new Participante();
        
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String idEvento = request.getParameter("idEvento");
        
        participante = EventosDAO.getInstance().realizaLogin(email, senha);
       
        if (!"0".equals(participante.getCodigo())) {
            if ((participante.getEmail().equals(email)) && (participante.getSenha().equals(senha))){
                Participante p = new Participante();
                p = EventosDAO.getInstance().buscaAmigo(Long.parseLong("2"), Long.parseLong(participante.getCodigo()));
                
                dispacher = request.getRequestDispatcher("/WEB-INF/eventos/amigo.jsp");
                
                request.setAttribute("amigo", p.getNome());
            }else{
                dispacher = request.getRequestDispatcher("/WEB-INF/eventos/login_erro.jsp");
            } 
        }else{
            dispacher = request.getRequestDispatcher("/WEB-INF/eventos/login_Erro.jsp");
        }    
        
        request.setAttribute("idEvento", idEvento);
        request.setAttribute("titulo", "Amigo");
        dispacher.forward(request, response);
    }
    
}
