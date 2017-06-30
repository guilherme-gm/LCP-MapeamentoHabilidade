<div class="row">
    <div class="col-sm-12">
        <h1>Adicionar Projetos</h1>
    </div>
</div>

<div class ="row">

    <form class="form-horizontal">
        <div class="row"> 
            &nbsp;&nbsp;
        </div>

        <div class="form-group">
            <label for="nome" class="col-sm-1 control-label">Nome</label>
            <div class="col-sm-4">
                <input class="form-control" type="text" name="nome" id =" nome" placeholder="Nome"/> <br />
            </div>
        </div>

        <div class="form-group row">
            <label for="dataInicio" class="col-sm-1 col-form-label">Data Inicio</label>
            <div class="col-sm-3">
                <input class="form-control " type="date" value="" name = "dataInicio" id="dataInicio">
            </div>
        </div>

        <div class="form-group row">
            <label for="dataFim" class="col-sm-1 col-form-label">Data Fim</label>
            <div class="col-sm-3">
                <input class="form-control " type="date" value="" name = "dataFim" id="dataFim">
            </div>
        </div>

        <div class="form-group row">
            <label for="descricao" class="col-sm-1 control-label">Descri&ccedil;&atilde;o:</label>
            <div class=" col-sm-6">
                <textarea class="form-control col-sm-4" rows="2" name = "descricao" id = "descricao"></textarea>
            </div>
        </div>

        <div class=" row">
            <label for="status" class="col-sm-1 control-label" placeholder="Status">Status</label>
            <div class=" col-sm-4">
                <select class="form-control" name = "status" id = "status">
                    <option>Em andamento</option>
                    <option>Cancelado</option>
                    <option>Finalizado</option>
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
