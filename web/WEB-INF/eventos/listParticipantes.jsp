<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../jspf/cabecalho.jspf" %>

<p>Lista de Participantes:</p>
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
                    <td>${participante.codigo}</td>
                    <td>${participante.nome}</td>
                    <td>${participante.email}</td>
                    <td>
                        <form method="post" action="excluiParticipante.html" onsubmit="return confirm('Clique em OK para EXCLUIR o participante ${participante.nome}.')">
                            <input type="hidden" name="id" value="${participante.codigo}" />
                            <input type="submit" value="Excluir"/>
                        </form>
                        <a href="editaParticipante.html?id=${participante.codigo}"><input type="submit" value="Editar"/></a>
                    </td>
            </tr>
            </c:forEach>
            <tr> <a href="novoParticipante.html"><input type="submit" value="Novo Participante"/></a></tr>
        </tbody>
    </table>

<%@include file="../jspf/rodape.jspf" %>
