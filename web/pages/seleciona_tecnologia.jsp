<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row ">
    <div class="col-sm-12">
        <h1>Selecione as Tecnologias</h1>
    </div>
</div>

<div class =" row">

    <table class="table table-hover">
        <thead>
            <tr>
                <th>Tecnologias para <c:out value="${projeto.nome}" /></th>
                <th>A&ccedil;&otilde;es</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${tecnologias}" var="tecnologia">
                <c:if test="${projeto.hasTecnologia(tecnologia) eq true}">
                    <tr class="info">
                        <td> <c:out value="${tecnologia.nome}"/> </td>
                        <td>
                            <a href="<c:url value="DoRemoverTecnologiaProjeto?id=${tecnologia.idTecnologia}"/>"> <span class=" glyphicon glyphicon-minus"></span></a>
                        </td>
                    </tr>
                </c:if>
                <c:if test="${projeto.hasTecnologia(tecnologia) eq false}">
                    <tr>
                        <td> <c:out value="${tecnologia.nome}"/> </td>
                        <td>
                            <a href="<c:url value="DoAdicionarTecnologiaProjeto?id=${tecnologia.idTecnologia}"/>"> <span class=" glyphicon glyphicon-plus"></span></a>
                        </td>
                    </tr>
                </c:if>
            </c:forEach>

        </tbody>
    </table>

    <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Pr&oacute;ximo</button>
        &nbsp;&nbsp;
        <button type="submit" class="btn btn-default">Voltar</button>
    </div>
</div>