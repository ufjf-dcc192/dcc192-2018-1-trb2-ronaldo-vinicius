package codigos;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListarInscritosEventoCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("idevento"));  
        RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/eventos/listInscritos.jsp");
        Evento evento = EventosDAO.getInstance().listaInscritosEvento(id);
        request.setAttribute("titulo", "Lista de Inscritos em Evento");
        request.setAttribute("eventos", evento);
        request.setAttribute("idEvento", id);
        dispacher.forward(request, response);
    }
    
}
