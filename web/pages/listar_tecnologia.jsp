<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty msg}">
    <div class="alert <c:out value="${msg_tipo}"></c:out>">
        <c:out value="${msg}"></c:out>
        </div>
</c:if>
<div class="row">
    <div class="col-sm-12">
        <h1>Lista de Tecnologias</h1>
    </div>
</div>
<div class="row">
    <div class="col-sm-12">
        <a href="<c:url value="CriarTecnologia"></c:url>"><span class="glyphicon glyphicon-plus"></span></a>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Nome da Tecnologia</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>PHP</td>
                        <td>
                            <a href="<c:url value="EditarTecnologia?id=1"></c:url>"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp;
                            <a onclick="remover_tecnologia_click(1)" href="#"><span class="glyphicon glyphicon-remove"></span></a>
                        </td>
                    </tr>
                    <tr>
                        <td>Java</td>
                        <td><span class="glyphicon glyphicon-pencil"></span>&nbsp;&nbsp;<span class="glyphicon glyphicon-remove"/></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Modal: Remover Tecnologia -->
    <div class="modal fade" id="remover" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Remover Tecnologia</h4>
                </div>
                <div class="modal-body">
                    Tem certeza que deseja remover esta tecnologia?
                </div>
                <div class="modal-footer">
                    <form method="POST" action="<c:url value="/DoExcluirTecnologia"></c:url>">
                    <input type="hidden" id="idTecnologia" name="idTecnologia"/>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                    <button type="submit" class="btn btn-primary">Excluir</button>
                </form> 
            </div>
        </div>
    </div>
</div>