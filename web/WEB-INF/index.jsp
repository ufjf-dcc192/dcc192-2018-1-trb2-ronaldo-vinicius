<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="jspf/cabecalho.jspf" %>

<p>Eventos de Amigo Oculto:</p>
    <table id="customers">
        <thead>
            <tr>
                <th>ID</th>
                <th>Títulos</th>
                <th>Preço Mínimo</th>
                <th>Data de Criação</th>
                <th>Data do Sorteio</th>
                <th>Ação</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="evento" items="${eventos}">
                <tr>
                    <td>${evento.codigo}</td>
                    <td>${evento.titulos}</td>
                    <td>${evento.minimo}</td>
                    <td>${evento.data}</td>
                    <td>${evento.sorteio}</td>
                    <td>
                        <form method="post" onsubmit="return confirm('Clique em OK para EXCLUIR o evento ${evento.titulos}.');">
                            <input type="hidden" name="id" value="${evento.codigo}" />
                            <input type="submit" value="Excluir"/>
                        </form>
                        <a href="listaInscritos.html?idevento=${evento.codigo}"><input type="submit" value="Participantes"/></a>
                    </td>
                </tr>

            </c:forEach>
            <tr><a href="novoevento.html"><input type="submit" value="Novo Evento"/></a></tr>
            <br><br>
        </tbody>
    </table>

<%@include file="jspf/rodape.jspf" %>
