package codigos;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NovoparticipanteCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/eventos/newParticipante.jsp");
        request.setAttribute("titulo", "Novo Participante");
        dispacher.forward(request, response);
    }
    
}
