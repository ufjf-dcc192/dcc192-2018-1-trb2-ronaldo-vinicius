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
    
    <input type="submit" value="Entrar" me/>
</form>
<%@include file="../jspf/rodape.jspf" %>
