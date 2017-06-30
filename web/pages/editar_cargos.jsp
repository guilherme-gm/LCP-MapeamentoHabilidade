<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class="col-sm-12">
        <h1>Adicionar Cargos</h1>
    </div>
</div>

<div class ="row">

    <form class="form-horizontal" method="POST" action="<c:url value="/DoEditarCargo"></c:url>">
        <div class="row"> 
        &nbsp;&nbsp;
        </div>

        <input type="hidden" name="idCargo" value="<c:out value="${cargo.idCargo}"></c:out>"/> <br />
        <div class="form-group">
            <label for="nome" class="col-sm-2 control-label">Nome</label>
            <div class="col-sm-4">
                <input class="form-control" type="text" name="nome" placeholder="Nome" value="<c:out value="${cargo.nome}"></c:out>"/> <br />
            </div>
        </div>

        <div class =" row">
            <h4> Permissões </h4>
        </div>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="1">
                Adicionar projetos
            </label>
        </div>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="2">
                Remover membro
            </label>
        </div>
        <p>
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Confirmar</button>
                &nbsp;&nbsp;
                <button type="submit" class="btn btn-default">Voltar</button>
            </div>

           
        </p>
    </form>
</div>
