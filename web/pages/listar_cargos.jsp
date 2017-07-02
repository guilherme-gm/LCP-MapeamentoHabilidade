<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty msg}">
    <div class="alert <c:out value="${msg_tipo}"></c:out>">
        <c:out value="${msg}"></c:out>
        </div>
</c:if>
<div class="row">
    <div class="col-sm-12">
        <h1>Lista de Cargos</h1>
    </div>
</div>
<div class="row">
    <div class="col-sm-12">
        <a href="<c:url value="CriarCargos"></c:url>"><span class="glyphicon glyphicon-plus"></span></a>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Nome do Cargo</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="cargo" items="${cargos}">
                    <tr>
                        <td><c:out value="${cargo.nome}"></c:out></td>
                            <td>
                                <a href="<c:url value="EditarCargo?idCargo=${cargo.idCargo}">"></c:url>"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp;
                            <a onclick="remover_cargo_click(<c:out value="${cargo.idCargo}"></c:out>)" href="#"><span class="glyphicon glyphicon-remove"></span></a>
                            </td>
                        </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<!-- Modal: Remover Cargo -->
<div class="modal fade" id="remover" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Remover Cargo</h4>
            </div>
            <div class="modal-body">
                Tem certeza que deseja remover este cargo?
            </div>
            <div class="modal-footer">
                <form method="POST" action="<c:url value="/DoExcluirCargo"></c:url>">
                    <input type="hidden" id="idCargo" name="idCargo"/>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                    <button type="submit" class="btn btn-primary">Excluir</button>
                </form>
            </div>
        </div>
    </div>
</div>