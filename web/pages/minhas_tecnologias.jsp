<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class="col-sm-12">
        <h1> Minhas Tecnologias</h1>
    </div>
</div>

<div class="row">
    <div class="col-sm-12">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Nome da Tecnologia</th>
                    <th>Nível da Tecnologia</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="tec" items = "${tecMembro}">
                    <tr>
                        <td><c:out value="${tec.tecnologia.nome}"/></td>
                        <td><c:out value="${tec.nivel}"/> </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
