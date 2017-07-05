<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class="col-sm-12">
        <h1>Adicionar Tecnologias</h1>
    </div>
</div>

<div class ="row">

    <form class="form-horizontal" method="POST" action = "<c:url value="/DoCriarHabilidadesMembro"/>">
        <div class="row"> 
            &nbsp;&nbsp;
        </div>

        <div class="form-group">
            <label for="tecnologia" class="col-sm-2 control-label">Tecnologia</label>
            <div class="col-sm-4">
                <select class="form-control" name="tecnologia" id="tecnologia">
                    <option value="1">Java</option>
                </select>
            </div>
        </div>

        <div class="form-group">
            <label for="nivel" class="col-sm-2 control-label">Nível</label>
            <div class="col-sm-4">
                <input class="form-control" type="number" name="nivel" id="nivel" placeholder="Nível"/> <br />
            </div>
        </div>

        <p>
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">Confirmar</button>
            &nbsp;&nbsp;
            <a href="<c:url value="/ListarHabilidadesMembro"/>" class="btn btn-default">Voltar</a>
        </div>


        </p>
    </form>
</div>
