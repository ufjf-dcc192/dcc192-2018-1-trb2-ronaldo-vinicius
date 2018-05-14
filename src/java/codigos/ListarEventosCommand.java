package codigos;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListarEventosCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/eventos/list.jsp");
        List<Evento> eventos = EventosDAO.getInstance().listEventos();
        request.setAttribute("titulo", "Lista de Eventos");
        request.setAttribute("eventos", eventos);
        dispacher.forward(request, response);
    }
    
}
