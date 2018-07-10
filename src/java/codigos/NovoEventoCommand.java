package codigos;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ice
 */
public class NovoEventoCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/eventos/newEvento.jsp");
//        List<Tarefa> tarefas = TarefaDAO.getInstance().listAll();
        request.setAttribute("titulo", "Novo Evento");
        dispacher.forward(request, response);
    }
    
}
