package codigos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class EditaParticipanteCommandPost implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String codigo = request.getParameter("id");
        EventosDAO.getInstance().updateParticipante(codigo, nome, email, senha);
        response.sendRedirect("participantes.html");
    }
    
}
