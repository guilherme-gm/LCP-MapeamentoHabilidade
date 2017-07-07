<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty msg}">
    <div class="alert <c:out value="${msg_tipo}"></c:out>">
        <c:out value="${msg}"></c:out>
        </div>
</c:if>
<div class="row">
    <div class="col-sm-12">
        <h1>Lista de Habilidades de <c:out value="${membro.nome}"/></h1>
    </div>
</div>
<div class="row">
    <div class="col-sm-12">
        <a href="<c:url value="CriarHabilidadesMembro?id=${membro.idMembro}"/>"><span class="glyphicon glyphicon-plus"></span></a>
    </div>
</div>
<div class="row">
    <div class="col-sm-12">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Nome da Tecnologia</th>
                    <th>Nível de Domínio</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="habilidades" items="${membro.tecnologiaMembro}">
                    <tr>
                        <td><c:out value="${habilidades.tecnologia.nome}"/></td>
                        <td><c:out value="${habilidades.nivel}"/></td>
                        <td>
                            <a onclick="editar_tecmembro_click(<c:out value="${habilidades.idTecnologiaMembro}"/>, '<c:out value="${habilidades.tecnologia.nome}"/>', <c:out value="${habilidades.nivel}"/>)" href="#"><span class="glyphicon glyphicon-pencil"></span></a>&nbsp;&nbsp;
                            <a onclick="remover_tecmembro_click(<c:out value="${habilidades.idTecnologiaMembro}"/>)" href="#"><span class="glyphicon glyphicon-remove"></span></a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<!-- Modal: Remover Tecnologia Membro -->
<div class="modal fade" id="remover" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Remover Tecnologia</h4>
            </div>
            <div class="modal-body">
                Tem certeza que deseja remover esta tecnologia do membro?
            </div>
            <div class="modal-footer">
                <form method="POST" action="<c:url value="/DoExcluirTecnologiaMembro"/>">
                    <input type="hidden" name="idMembro" value="<c:out value="${membro.idMembro}"/>"/>
                    <input type="hidden" id="idTecno" name="idTecno"/>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                    <button type="submit" class="btn btn-primary">Excluir</button>
                </form> 
            </div>
        </div>
    </div>
</div>
<!-- Modal: Editar Tecnologia Membro -->
<form method="POST" action="<c:url value="/DoEditarTecnologiaMembro"/>">
    <input type="hidden" name="idMembro" value="<c:out value="${membro.idMembro}"/>"/>
    <input type="hidden" id="idTecnologiaMembro" name="idTecnologiaMembro"/>

    <div class="modal fade" id="editar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Editar Nível do Membro</h4>
                </div>
                <div class="modal-body">
                    Qual deve ser o novo nível de habilidade do membro em <span id="nomeTecno"></span><br />
                    <input class="form-control" type="number" name="nivel" id="nivel" placeholder="Nível"/>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                    <button type="submit" class="btn btn-primary">Editar</button>
                </div>
            </div>
        </div>
    </div>

</form>
</div>