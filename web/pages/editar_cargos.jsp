<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class="col-sm-12">
        <h1>Adicionar Cargos</h1>
    </div>
</div>

<c:if test="${not empty msg}">
    <div class="alert <c:out value="${msg_tipo}"></c:out>">
        ${msg}
    </div>
</c:if>

<div class="row">
    <form class="form-horizontal" method="POST" action="<c:url value="/DoEditarCargo"/>">
        <div class="row"> 
            &nbsp;&nbsp;
        </div>

        <input type="hidden" name="idCargo" value="<c:out value="${cargo.idCargo}"/>"/> <br />
        <div class="form-group">
            <label for="nome" class="col-sm-2 control-label">Nome</label>
            <div class="col-sm-4">
                <input class="form-control" type="text" name="nome" placeholder="Nome" value="<c:out value="${cargo.nome}"/>"/> <br />
            </div>
        </div>

        <div class="row">
            <div class="col-sm-12">
                <h4> Permissões </h4>
            </div>
        </div>
        <c:forEach items="${permissoes}" var="p">
            <div class="checkbox">
                <label>
                    <input type="checkbox"
                           name="permissao"
                           value="<c:out value="${p}" />"
                           <c:if test="${cargo.hasPermissao(p) eq true}">
                               checked="checked"
                           </c:if>
                           />
                    <span><c:out value="${p.displayName}"/></span>
                </label>
            </div>
        </c:forEach>

        <p>
        <div class="row">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" class="btn btn-default" value="Confirmar" />
                &nbsp;&nbsp;
                <a href="<c:url value="/ListarCargo"/>" class="btn btn-default">Voltar</a>
            </div>
        </div>
        </p>
    </form>
</div>
