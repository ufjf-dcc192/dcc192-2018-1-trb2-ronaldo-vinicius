<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../jspf/cabecalho.jspf" %>    

    <body>
        <div class="label-amigo">
            Seu amigo é: <%=request.getAttribute("amigo")  %>
        </div>
        
        <a href="listaInscritos.html?idevento=<%=request.getAttribute("idEvento")%>"><input type="submit" value="<< Voltar"/></a>
    </body>