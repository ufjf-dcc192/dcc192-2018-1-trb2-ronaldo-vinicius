<%@page import="codigos.EventosDAO"%>
<%@page import="codigos.Participante"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../jspf/cabecalho.jspf" %>
<p>Participante</p>
<form method="POST">
        <label>
            Nome: 
            <input type="text" name="nome" value="${participante.nome}" />
        </label>
        <label>
            Email 
            <input type="email" name="email" value="${participante.email}" />
        </label>
        <label>
            Senha 
            <input type="password" name="senha" value="${participante.senha}" />
        </label>
    <input type="submit" value="Gravar" />
</form>
<%@include file="../jspf/rodape.jspf" %>
