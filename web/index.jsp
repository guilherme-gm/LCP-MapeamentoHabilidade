<%-- 
    Document   : index
    Created on : Jun 2, 2017, 11:10:43 AM
    Author     : guilh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mapeamento de Habilidades</title>
    </head>
    <body>
        <div>
            <div><jsp:include page="header.jsp" flush="true" /></div>
            <div>
                <div><jsp:include page="menu.jsp" flush="true" /></div>
                <div><jsp:include page="pages/${page}.jsp" flush="true" /></div>
            </div>
            <div><jsp:include page="footer.jsp" flush="true" /></div>
        </div>
    </body>
</html>
