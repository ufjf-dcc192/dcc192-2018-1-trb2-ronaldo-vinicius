<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../jspf/cabecalho.jspf" %>
<link rel="stylesheet" href="../css/colour.css">
<link rel="stylesheet" href="../css/template.css">

<p>Participantes</p>
<div class="grid_16">
    <table>
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
                        <a href="novoInscrito.html?id=${participante.codigo}"><input type="submit" value="Selecionar"/></a>
                    </td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<%@include file="../jspf/rodape.jspf" %>
