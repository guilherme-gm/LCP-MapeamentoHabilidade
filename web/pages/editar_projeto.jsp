<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class="col-sm-12">
        <h1>Editar Projeto</h1>
    </div>
</div>

<div class ="row">

    <form class="form-horizontal col-sm-12" method="POST" action="<c:url value="/DoEditarProjeto"/>">
        <div class="row col-sm-12"> 
            &nbsp;&nbsp;
        </div>

        <div class="form-group col-sm-12">
            <label for="nome" class="col-sm-1 control-label">Nome</label>
            <div class="col-sm-7">
                <input class="form-control" type="text" name="nome" id="nome" placeholder="Nome" value="<c:out value="${projeto.nome}"/>" /> <br />
            </div>
        </div>

        <div class="form-group row col-sm-12">
            <label for="dataInicio" class="col-sm-1 col-form-label">Data Inicio</label>
            <div class="col-sm-3">
                <input class="form-control" type="date" name="dataInicio" id="dataInicio" value="<c:out value="${projeto.dataInicio}"/>">
            </div>
        </div>

        <div class="form-group row col-sm-12">
            <label for="dataFim" class="col-sm-1 col-form-label">Data Fim</label>
            <div class="col-sm-3">
                <input class="form-control" type="date" name="dataFim" id="dataFim" value="<c:out value="${projeto.dataFim}"/>">
            </div>
        </div>

        <div class="form-group row col-sm-12">
            <label for="descricao" class="col-sm-1 control-label">Descri&ccedil;&atilde;o:</label>
            <div class="col-sm-7">
                <textarea class="form-control col-sm-4" rows="2" name="descricao" id="descricao"><c:out value="${projeto.descricao}"/></textarea>
            </div>
        </div>

        <div class=" row col-sm-12">
            <label for="status" class="col-sm-1 control-label" placeholder="Status">Status</label>
            <div class="col-sm-4">
                <select class="form-control" name="pstatus" id="status">
                    <c:forEach items="${status}" var="s">
                        <option value="<c:out value="${s}"/>" <c:if test="${projeto.status eq s}">selected="selected"</c:if>><c:out value="${s.displayName}"/></option>
                    </c:forEach>
                </select>
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
