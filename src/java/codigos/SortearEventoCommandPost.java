package codigos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SortearEventoCommandPost implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long idEvento = Long.parseLong(request.getParameter("idEvento"));
        String idAmigo = null;
        Long idParticipante = null;
        
        EventosDAO.getInstance().atualizaStatusEvento(idEvento);        
        Evento evento = EventosDAO.getInstance().listaInscritosEvento(idEvento);
        
        List<Integer> numeros = new ArrayList<Integer>();
        for (int i = 0; i < evento.getInscritos().size(); i++) { //Sequencia da mega sena
            numeros.add(i + 1);
        }
        //Embaralhamos os números:
        Collections.shuffle(numeros);
        
        for(int j = 0; j < numeros.size(); j++){
            idParticipante = Long.parseLong(evento.getInscritos().get(0).getCodigo());
            idAmigo = numeros.get(j) + "";
            evento.getInscritos().get(0).getCodigo();
            EventosDAO.getInstance().atualizaAmigo(idEvento, Long.parseLong(idAmigo), idParticipante);
            evento.getInscritos().remove(0);
        }
        
        RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/eventos/listInscritos.jsp");
        request.setAttribute("titulo", "Lista de Inscritos em Evento");
        request.setAttribute("eventos", evento);
        request.setAttribute("idEvento", idEvento);
        response.sendRedirect("listaInscritos.html?idevento=" + idEvento);
    }
    
}
