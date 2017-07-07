<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class="col-sm-12">
        <h1>Adicionar Projetos</h1>
    </div>
</div>
<c:if test="${not empty msg}">
    <div class="alert <c:out value="${msg_tipo}"></c:out>">
        ${msg}
    </div>
</c:if>
<div class ="row">

    <form class="form-horizontal col-sm-12" method="POST" action="<c:url value="/DoCriarProjeto"/>">
        <div class="row col-sm-12"> 
            &nbsp;&nbsp;
        </div>

        <div class="form-group col-sm-12">
            <label for="nome" class="col-sm-2 control-label" style="text-align: left">Nome</label>
            <div class="col-sm-7">
                <input class="form-control" type="text" name="nome" id="Nome" placeholder="Nome" value="<c:out value="${projeto.nome}"/>" /> <br />
            </div>
        </div>

        <div class="form-group row col-sm-12">
            <label for="dataInicio" class="col-sm-2 col-form-label" style="text-align: left">Data Inicio</label>
            <div class="col-sm-3">
                <input class="form-control" type="date" name="dataInicio" id="dataInicio" value="<c:out value="${projeto.dataInicio}"/>">
            </div>
        </div>

        <div class="form-group row col-sm-12">
            <label for="dataEntrega" class="col-sm-2 col-form-label" style="text-align: left">Data de Entrega</label>
            <div class="col-sm-3">
                <input class="form-control" type="date" name="dataFim" id="dataEntrega" value="<c:out value="${projeto.dataFim}"/>">
            </div>
        </div>

        <div class="form-group row col-sm-12">
            <label for="descricao" class="col-sm-2 control-label" style="text-align: left">Descri&ccedil;&atilde;o</label>
            <div class="col-sm-7">
                <textarea class="form-control col-sm-4" rows="2" name="descricao" id="descricao"><c:out value="${projeto.descricao}"/></textarea>
            </div>
        </div>

        <div class=" row col-sm-12">
            <label class="col-sm-2">Status</label>
            <div class="col-sm-4">
                 <label style="text-align: center" > Em andamento</label>
            </div>
        </div>
        <div class="row col-sm-12"> 
            &nbsp;&nbsp;
        </div>

        <div class="col-sm-offset-2 col-sm-10">
            <input type="submit" class="btn btn-default" value="Pr&oacute;ximo"/>
            &nbsp;&nbsp;
            <a href="<c:url value="/ListarProjeto"/>" class="btn btn-default">Voltar</a>
        </div>


    </form>
</div>
