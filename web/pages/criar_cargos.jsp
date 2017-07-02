<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class="col-sm-12">
        <h1>Adicionar Cargos</h1>
    </div>
</div>

<div class ="row">

    <form class="form-horizontal" method="POST" action="<c:url value="/DoCriarCargo"></c:url>">
        <div class="row"> 
            &nbsp;&nbsp;
        </div>

        <div class="form-group">
            <label for="nome" class="col-sm-2 control-label">Nome</label>
            <div class="col-sm-4">
                <input class="form-control" type="text" name="nome" placeholder="Nome"/> <br />
            </div>
        </div>

        <div class =" row">
            <h4> Permissões </h4>
        </div>
        <div class="checkbox">
            <label>
                <input type="checkbox" name="permissao" value="GERENCIAR_PROJETOS">
                Gerenciar Projetos
            </label>
        </div>
        <div class="checkbox">
            <label>
                <input type="checkbox" name="permissao" value="GERENCIAR_CARGOS">
                Gerenciar Cargos
            </label>
        </div>
        <div class="checkbox">
            <label>
                <input type="checkbox" name="permissao" value="GERENCIAR_HABILIDADES">
                Gerenciar Habilidades
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
