<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../jspf/cabecalho.jspf" %>

<p>Participantes</p>
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
            <c:forEach var="participante" items="${participantes}">
                <tr>
                    <td>${participante.codigo }</td>
                    <td>${participante.nome}</td>
                    <td>${participante.email}</td>
                    <td>
                        <form method="post" action="selecionarInscrito.html">
                            <input  type="hidden" name="idEvento" value="<%=request.getParameter("idEvento")%>">
                            <input  type="hidden" name="idParticipante" value="${participante.codigo}">
                            <input type="submit" value="Selecionar"/>
                        </form>                        
                    </td>
            </tr>
            </c:forEach>
        </tbody>
    </table>

<%@include file="../jspf/rodape.jspf" %>
