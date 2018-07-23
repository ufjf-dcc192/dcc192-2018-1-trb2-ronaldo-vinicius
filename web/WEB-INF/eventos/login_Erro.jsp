<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../jspf/cabecalho.jspf" %>
<p>Login</p>
<form method="POST" action="amigo.html">
    <label>
        Email 
        <input type="text" name="email" value="" />
    </label>
    <label>
        Senha 
        <input type="password" name="senha" value="" />
    </label>
    <label>EMAIL OU SENHA INCORRETOS</label>
    <input type="submit" value="Gravar" me/>
</form>
<%@include file="../jspf/rodape.jspf" %>
