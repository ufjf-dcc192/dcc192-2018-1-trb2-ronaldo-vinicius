<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../jspf/cabecalho.jspf" %>    

    <body>
        <div class="label-amigo">
            Seu amigo �: <%=request.getAttribute("amigo")  %>
        </div>
    </body>