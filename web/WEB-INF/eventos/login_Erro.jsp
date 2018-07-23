<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../jspf/cabecalho.jspf" %>
<BR><BR>
<form method="POST" action="amigo.html">
    <label>
        Email 
        <input type="text" name="email" value="" />
    </label>
    <BR>
    <label>
        Senha 
        <input type="password" name="senha" value="" />
    </label>  
    <BR>
    
    <input type="hidden" name="idEvento" value="<%=request.getParameter("id_evento")%>" />
 
    <input type="submit" value="Entrar" me/>
    
    <BR><BR>
    <label class="login-erro">EMAIL OU SENHA INCORRETOS</label>   
</form>
<%@include file="../jspf/rodape.jspf" %>


