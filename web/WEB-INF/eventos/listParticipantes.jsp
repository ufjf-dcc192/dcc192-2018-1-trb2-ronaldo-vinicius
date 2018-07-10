<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../jspf/cabecalho.jspf" %>
<p>Lista de Participantes:</p>
<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Email</th>
            <th>Senha</th>
            <th>Ações</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="participante" items="${participantes}">
            <tr>
                <td>${participante.codigo }</td>
                <td>${participante.nome}</td>
                <td>${participante.email}</td>
                <td>${participante.senha}</td>
                <td>
                    <form method="post" action="excluiParticipante.html">
                        <input type="hidden" name="id" value="${participante.codigo}" />
                        <input type="submit" value="Excluir"/>
                        <!--<input type="submit" value="X"/>-->
                    </form>
                    <a href="editaParticipante.html?id=${participante.codigo}"><input type="submit" value="Editar"/></a>
                </td>
        </tr>
        </c:forEach>
        <tr> <a href="novoParticipante.html">Novo Participante</a></tr>
    </tbody>
</table>
<%@include file="../jspf/rodape.jspf" %>
