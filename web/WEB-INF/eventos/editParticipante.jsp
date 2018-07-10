<%@page import="codigos.EventosDAO"%>
<%@page import="codigos.Participante"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../jspf/cabecalho.jspf" %>
<p>Participante</p>
<form method="POST">
    <%
        Participante p = EventosDAO.getInstance().buscaParticipantes(request.getParameter("id"));        
    %> 
        <label>
            Nome: 
            <input type="text" name="nome" value="<%=p.getNome()%>" />
        </label>
        <label>
            Email 
            <input type="text" name="email" value="<%=p.getEmail()%>" />
        </label>
        <label>
            Senha 
            <input type="password" name="senha" value="<%=p.getSenha()%>" />
        </label>
    <input type="submit" value="Gravar" />
</form>
<%@include file="../jspf/rodape.jspf" %>
