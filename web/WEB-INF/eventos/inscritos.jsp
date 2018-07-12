<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../jspf/cabecalho.jspf" %>
<p>Tarefas a serem feitas:</p>
<p><a href="inscricao.html">[Adicionar]</a></p>
<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Email</th>
            <th>Sorteio</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="inscrito" items="${inscritos}">
            <tr>
                <td>${inscrito.id}</td>
                <td>${inscrito.nome}</td>
                <td>${inscrito.email}</td>
                <td>"?"</td>
                <td>
                    <form method="post" action="inscrito-exclui.html" onsubmit="confirm('Clique em OK para DESINSCREVER o participante ${inscrito.nome}.')">
                        <input type="hidden" name="id" value="${inscrito.id}" />
                        <input type="submit" value="Desinscrever"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<%@include file="../jspf/rodape.jspf" %>