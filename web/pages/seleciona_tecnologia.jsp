<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row ">
    <div class="col-sm-12">
        <h1>Selecione as Tecnologias</h1>
    </div>
</div>

<div class =" row">
    <form class="col-sm-12" action="<c:url value = "/SelecionaMembro"></c:url>">
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>Tecnologia</th>
                    <th>A&ccedil;&otilde;es</th>
                </tr>
            </thead>
            <body>
                 <tr class="info">
                <td> C </td>
                <td>
                    <a href="<c:url value="AdicionaMembroProjeto?id=1"></c:url>"> <span class=" glyphicon glyphicon-minus"></span></a>
                </td>
            </tr>
            <tr>
                <td>Java </td>
                <td>
                    <a href="<c:url value="AdicionaMembroProjeto?id=1"></c:url>"><span class="glyphicon glyphicon-plus"></span></a>
                </td>
            </tr>
             <tr>
                <td>Python</td>
                <td>
                    <a href="<c:url value="AdicionaMembroProjeto?id=1"></c:url>"><span class="glyphicon glyphicon-plus"></span></a>
                </td>
            </tr>
            <tr class="info">
                <td> JavaScript </td>
                <td>
                    <a href="<c:url value="AdicionaMembroProjeto?id=1"></c:url>"><span class=" glyphicon glyphicon-minus"></span></a>
                </td>
            </tr>

            </body>
        </table>
        
         <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">Pr&oacute;ximo</button>
            &nbsp;&nbsp;
            <button type="submit" class="btn btn-default">Voltar</button>
        </div>
        
    </form>
</div>