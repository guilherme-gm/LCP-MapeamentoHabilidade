<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="row">
    <div class="col-sm-12">
        <h1>Meus Projetos</h1>
    </div>
</div>
<div class="row">
    <div class="col-sm-12">
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>Nome do Projeto</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${projetos}" var="projeto">
                    <tr class="prj-${fn:toLowerCase(projeto.status)}">
                        <td><c:out value="${projeto.nome}" /></td>
                        <td><c:out value="${projeto.status.getDisplayName()}" /></td>
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
                Remover este projeto <b>apagará todas</b> as informações relacionadas a ele!<br />
                Se ainda assim deseja continuar, <b>digite o nome do projeto na caixa abaixo</b>:<br />
                <input type="text" id="projNome" oninput="remover_projeto_change()"/>
            </div>
            <div class="modal-footer">
                <form method="POST" action="<c:url value="/DoExcluirProjeto"/>">
                    <input type="hidden" id="delNome" />
                    <input type="hidden" id="idProjeto" name="idProjeto"/>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                    <button type="submit" id="btnDeleta" class="btn btn-primary">Excluir</button>
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
