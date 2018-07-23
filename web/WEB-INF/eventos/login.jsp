<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../jspf/cabecalho.jspf" %>
<BR><BR>
<form method="POST" action="amigo.html">
    <label>
        Email 
        <input type="email" name="email" value="" />
    </label>
    <BR>
    <label>
        Senha 
        <input type="password" name="senha" value="" />
    </label>  
    <BR>
    
    <input type="hidden" name="idEvento" value="<%=request.getParameter("id_evento")%>" />
    
    <input type="submit" value="Entrar" me/>
</form>
    <BR>
    <a href="listaInscritos.html?idevento=<%=request.getParameter("id_evento")%>"><input type="submit" value="<< Voltar"/></a>
    
<%@include file="../jspf/rodape.jspf" %>
