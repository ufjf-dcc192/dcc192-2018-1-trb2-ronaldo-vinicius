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
        String sorteado = "N";
        RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/eventos/listInscritos.jsp");
        Evento lstInscritos = EventosDAO.getInstance().listaInscritosEvento(id);
        Evento evento = EventosDAO.getInstance().buscaEvento(id);
        
        if ("N".equals(evento.getSorteado())){
            sorteado = "N";
        }else{
            sorteado = "S";
        }       
        
        request.setAttribute("titulo", "Lista de Inscritos em Evento");
        request.setAttribute("lstInscritos", lstInscritos);
        request.setAttribute("idEvento", id);
        request.setAttribute("sorteado", sorteado);
        dispacher.forward(request, response);        
    }
    
}
