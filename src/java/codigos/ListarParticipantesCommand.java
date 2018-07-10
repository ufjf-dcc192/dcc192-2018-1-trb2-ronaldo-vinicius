package codigos;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListarParticipantesCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/eventos/listParticipantes.jsp");
        List<Participante> participantes = EventosDAO.getInstance().listParticipantes();
        request.setAttribute("titulos", "Lista de Participantes");
        request.setAttribute("participantes", participantes);
        dispacher.forward(request, response);
    }
    
}
