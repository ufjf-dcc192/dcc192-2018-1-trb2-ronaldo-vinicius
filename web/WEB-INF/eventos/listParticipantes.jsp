<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../jspf/cabecalho.jspf" %>
<p>Lista de Participantes:</p>
<!--https://docs.google.com/document/d/10MoReDSczzfsYwgdFi-xP9vyRuH6roXi-mKBznrMK4k/edit#-->
<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Email</th>
            <th>Senha</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="participantes" items="${participante}">
            <tr>
                <td>${participantes.getCodigo}</td>
                <td>${participantes.getNome}</td>
                <td>${participantes.getEmail}</td>
                <td>${participantes.getSenha}</td>
                <td>
                    <form method="post" action="#">
                        <input type="hidden" name="id" value="${evento.codigo}" />
                        <input type="button" value="Excluir"/>
                        <!--<input type="submit" value="X"/>-->
                    </form>                    
                </td>
        </tr>
        </c:forEach>
        <tr> <a href="novoParticipante.html">Novo Participante</a></tr>
    </tbody>
</table>
<%@include file="../jspf/rodape.jspf" %>
