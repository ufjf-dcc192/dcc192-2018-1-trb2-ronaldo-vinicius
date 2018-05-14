<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../jspf/cabecalho.jspf" %>
<p>Eventos de Amigo Oculto:</p>
<p><a href="novoevento.html">[Criar Evento]</a></p>
<!--https://docs.google.com/document/d/10MoReDSczzfsYwgdFi-xP9vyRuH6roXi-mKBznrMK4k/edit#-->
<table>
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
                <td>${evento.titulo}</td>
                <td>${evento.minimo}</td>
                <td>${evento.data}</td>
                <td>${evento.sorteio}</td>
                <td>
                    <form method="post" action="#">
                        <input type="hidden" name="id" value="${evento.id}" />
                        <input type="button" value="X"/>
                        <!--<input type="submit" value="X"/>-->
                    </form>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<%@include file="../jspf/rodape.jspf" %>
