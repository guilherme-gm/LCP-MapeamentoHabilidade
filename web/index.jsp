<%-- 
    Document   : index
    Created on : Jun 2, 2017, 11:10:43 AM
    Author     : guilh
    Description: Esqueleto do site
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Mapeamento de Habilidades</title>

        <!-- Bootstrap -->
        <link href="<c:url value="/css/bootstrap.min.css"></c:url>" rel="stylesheet">

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
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

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="<c:url value="/js/bootstrap.min.js"></c:url>"></script>
    </body>
</html>
