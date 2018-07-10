package codigos;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditaParticipanteCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/eventos/editParticipante.jsp");
        Long id = Long.parseLong(request.getParameter("id"));                    
        Participante part =  EventosDAO.getInstance().buscaParticipantes(id);
        request.setAttribute("titulo", "Edita Participante");
        request.setAttribute("participante", part);
        dispacher.forward(request, response);
    }
    
}
