package codigos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class DeletaInscritoCommandPost implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long idEvento = Long.parseLong(request.getParameter("idEvento"));                    
        Long idInscrito = Long.parseLong(request.getParameter("idInscrito"));                    
        EventosDAO.getInstance().deleteInscrito(idEvento, idInscrito);
        response.sendRedirect("listaInscritos.html?idevento=" + request.getParameter("idEvento"));
    }
    
}
