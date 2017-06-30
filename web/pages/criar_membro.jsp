<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class="col-sm-12">
        <h1>Adicionar Membro</h1>
    </div>
</div>

<div class ="row">

    <form class="form-horizontal">
        <div class="row"> 
            &nbsp;&nbsp;
        </div>

        <div class="form-group">
            <label for="nome" class="col-sm-2 control-label">Nome</label>
            <div class="col-sm-4">
                <input class="form-control" type="text" name="nome" placeholder="Nome"/> <br />
            </div>
        </div>
        <div class="form-group">
            <label for="telefone" class="col-sm-2 control-label">Telefone</label>
            <div class="col-sm-4">
                <input class="form-control" type="tel" name="telefone" placeholder="Telefone" id="telefone"/> <br />
            </div>
        </div>
        <div class="form-group">
            <label for="email" class="col-sm-2 control-label">E-mail</label>
            <div class="col-sm-4">
                <input class="form-control" type="email" name="email" placeholder="E-mail" id="email" required=""/> <br />
            </div>
        </div>
        <div class="form-group">
            <label for="cargo" class="col-sm-2 control-label">Cargo</label>
            <div class="col-sm-4">
                <select id="cargo" nome="cargo" class="form-control">
                    <option value="1">Diretor de RH</option>
                    <option value="2">Diretor de Projetos</option>
                    <option value="3">Gerente</option>
                    <option value="4">Assessor de RH</option>
                </select>
            </div>
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
