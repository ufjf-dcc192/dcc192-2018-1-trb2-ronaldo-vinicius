<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../jspf/cabecalho.jspf" %>
<p>Novo Evento</p>
<form method="POST">
    <label>
        Titulo: 
        <input type="text" name="titulo" value="" />
    </label>
    <label>
        Valor Minimo: 
        <input type="text" name="vlrMinimo" value="" />
    </label>
    <label>
        Data Sorteio: 
        <input type="text" name="dataSorteio" value="" />
    </label>
    <input type="submit" value="Gravar" me/>
</form>
<%@include file="../jspf/rodape.jspf" %>
