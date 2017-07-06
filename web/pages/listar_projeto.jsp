<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:if test="${not empty msg}">
    <div class="alert <c:out value="${msg_tipo}"></c:out>">
        <c:out value="${msg}"></c:out>
        </div>
</c:if>
<div class="row">
    <div class="col-sm-12">
        <h1>Lista de Projetos</h1>
    </div>
</div>
<div class="row">
    <div class="col-sm-12">
        <a href="<c:url value="CriarProjetos"></c:url>"><span class="glyphicon glyphicon-plus"></span></a>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Nome do Projeto</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${projetos}" var="projeto">
                    <tr class="prj-${fn:toLowerCase(projeto.status)}">
                        <td><c:out value="${projeto.nome}" /></td>
                        <td>
                            <a href="<c:url value="EditarProjeto?id=${projeto.idProjeto}" />"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp;
                            <a onclick="finalizar_projeto_click(<c:out value="${projeto.idProjeto}"/>)" href="#"><span class="glyphicon glyphicon-ok"></span></a>&nbsp;&nbsp;
                            <a onclick="cancelar_projeto_click(<c:out value="${projeto.idProjeto}"/>)" href="#"><span class="glyphicon glyphicon-ban-circle"></span></a>&nbsp;&nbsp;
                            <a onclick="remover_projeto_click(<c:out value="${projeto.idProjeto}"/>)" href="#"><span class="glyphicon glyphicon-remove"></span></a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<!-- Modal: Remover Projeto -->
<div class="modal fade" id="remover" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Remover Projeto</h4>
            </div>
            <div class="modal-body">
                Tem certeza que deseja remover este projeto?
            </div>
            <div class="modal-footer">
                <form method="POST" action="<c:url value="/DoExcluirProjeto"/>">
                    <input type="hidden" id="idProjeto" name="idProjeto"/>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                    <button type="submit" class="btn btn-primary">Excluir</button>
                </form> 
            </div>
        </div>
    </div>
</div>

<!-- Modal: Finalizar Projeto -->
<div class="modal fade" id="concluir" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Concluir Projeto</h4>
            </div>
            <div class="modal-body">
                Tem certeza que deseja marcar este projeto como concluído?
            </div>
            <div class="modal-footer">
                <form method="POST" action="<c:url value="/DoFinalizarProjeto"/>">
                    <input type="hidden" id="idConcluir" name="idProjeto"/>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                    <button type="submit" class="btn btn-primary">Concluir</button>
                </form> 
            </div>
        </div>
    </div>
</div>

<!-- Modal: Cancelar Projeto -->
<div class="modal fade" id="cancelar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Cancelar Projeto</h4>
            </div>
            <div class="modal-body">
                Tem certeza que deseja marcar este projeto como cancelado?
            </div>
            <div class="modal-footer">
                <form method="POST" action="<c:url value="/DoCancelarProjeto"/>">
                    <input type="hidden" id="idCancelar" name="idProjeto"/>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                    <button type="submit" class="btn btn-primary">Cancelar</button>
                </form> 
            </div>
        </div>
    </div>
</div>
