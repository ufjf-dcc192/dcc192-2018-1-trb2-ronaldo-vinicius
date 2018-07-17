<%@page import="codigos.Evento"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../jspf/cabecalho.jspf" %>
<link rel="stylesheet" href="../css/colour.css">
<link rel="stylesheet" href="../css/template.css">

<p>Inscritos em Evento</p>
    <table id="customers">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Email</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="evento" items="${eventos.inscritos}">
                <tr>
                    <td>${evento.codigo }</td>
                    <td>${evento.nome}</td>
                    <td>${evento.email}</td>
                    <td><a href="amigo.html"><input type="submit" value="Ver Amigo"/></a></td>
                    <td>?</td>
                    <td>
                        <form method="post" action="excluiInscrito.html" onsubmit="return confirm('Clique em OK para EXCLUIR o inscrito ${evento.codigo}.')">
                            <input type="hidden" name="idInscrito" value="${evento.codigo}" />
                            <input type="hidden" name="idEvento" value="<%=request.getAttribute("idEvento") %>" />
                            <input type="submit" value="Excluir"/>
                        </form>                        
                    </td>
            </tr>
            </c:forEach>
        
            <tr> <a href="novoInscrito.html?idEvento=${eventos.codigo}"><input type="submit" value="Inscrever Participante"/></a></tr>
            <br><br>
        </tbody>
    </table>
        <br>
    <a href="sortearEvento.html"><input type="submit" value="Sortear"/></a>
<%@include file="../jspf/rodape.jspf" %>
