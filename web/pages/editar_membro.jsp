<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class="col-sm-12">
        <h1>Editar Membro</h1>
    </div>
</div>
<c:if test="${not empty msg}">
    <div class="alert <c:out value="${msg_tipo}"></c:out>">
        ${msg}
    </div>
</c:if>
<div class ="row">
    <form method="POST" action="<c:url value="/DoEditarMembro"/> " class="form-horizontal">
        <input type="hidden" name="idMembro" value="<c:out value="${membro.idMembro}"/>"/><br />
        <div class="row"> 
            &nbsp;&nbsp;
        </div>

        <div class="form-group">
            <label for="nome" class="col-sm-2 control-label">Nome</label>
            <div class="col-sm-4">
                <input class="form-control" type="text" name="nome" placeholder="Nome" value="<c:out value="${membro.nome}"/>"/> <br />
            </div>
        </div>
        <div class="form-group">
            <label for="telefone" class="col-sm-2 control-label">Telefone</label>
            <div class="col-sm-4">
                <input class="form-control" type="tel" name="telefone" placeholder="Telefone" id="telefone" value="<c:out value="${membro.telefone}"/>"/> <br />
            </div>
        </div>
        <div class="form-group">
            <label for="email" class="col-sm-2 control-label">E-mail</label>
            <div class="col-sm-4">
                <input class="form-control" type="email" name="email" placeholder="E-mail" id="email" required="" value="<c:out value="${membro.email}"/>"/> <br />
            </div>
        </div>       
        <div class="form-group">
            <label for="cargo" class="col-sm-2 control-label">Cargo</label>
            <div class="col-sm-4">
                <select id="cargo" name="idCargo" class="form-control">
                    <c:forEach var="cargo" items="${Cargos}">
                        <option value="<c:out value="${cargo.idCargo}"/>"><c:out value="${cargo.nome}"/></option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <p>
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">Confirmar</button>
            &nbsp;&nbsp;
            <a href="<c:url value="/ListarMembro"/>" class="btn btn-default">Voltar</a>
        </div>
        </p>
    </form>
</div>
