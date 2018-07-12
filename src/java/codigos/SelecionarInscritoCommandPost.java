package codigos;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelecionarInscritoCommandPost implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long idEvento = Long.parseLong(request.getParameter("idEvento"));
        Long idParticipante = Long.parseLong(request.getParameter("idParticipante"));
        
        EventosDAO.getInstance().insereNovoInscrito(idEvento, idParticipante);
        
        RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/eventos/listInscritos.jsp");
        Evento evento = EventosDAO.getInstance().listaInscritosEvento(idEvento);
        request.setAttribute("titulo", "Lista de Inscritos em Evento");
        request.setAttribute("eventos", evento);
        dispacher.forward(request, response);
    }
    
}
