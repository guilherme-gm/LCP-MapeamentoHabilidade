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

        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    </head>
    <body>
        <div class="container" id="content" tabindex="-1">
            <div class="row">
                <div class="col-sm-12"><jsp:include page="header.jsp" flush="true" /></div>
            </div>
            <div class="row">
                <div class="col-sm-2"><jsp:include page="menu.jsp" flush="true" /></div>
                <div class="col-sm-10"><jsp:include page="pages/${page}.jsp" flush="true" /></div>
            </div>
            <div class="row">
                <div class="col-sm-12"><jsp:include page="footer.jsp" flush="true" /></div>
            </div>
        </div>

        <!-- Latest compiled and minified JavaScript -->
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>

        <script src="./js/site.js"></script>
    </body>
</html>
