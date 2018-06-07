package codigos;

import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class NovoEventoCommandPost implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titulo = request.getParameter("titulo");
        String vlrMinimo = request.getParameter("vlrMinimo");
        String dataSorteio = request.getParameter("dataSorteio");
        try {
            EventosDAO.getInstance().createEvento(titulo, Float.parseFloat(vlrMinimo), dataSorteio);
        } catch (ParseException ex) {
            Logger.getLogger(NovoEventoCommandPost.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("eventos.html");
    }
    
}
